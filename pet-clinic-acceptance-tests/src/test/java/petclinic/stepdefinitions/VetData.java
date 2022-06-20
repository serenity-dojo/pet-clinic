package petclinic.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import petclinic.Veterinarian;
import petclinic.screenplay.navigation.Navigate;
import petclinic.screenplay.questions.DisplayedVet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class VetData {

    @Given("{actor} is a {}")
    public void aPetClinicOwner(Actor actor, String role) {
        actor.describedAs(role);
        actor.attemptsTo(
                Navigate.toTheVetApplicationHomePage()
        );
    }

    @When("{actor} views the vets in his clinic")
    public void heViewsTheVetsInHisClinic(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheVeterinariansList()
        );
    }

    @Then("{actor} should see the name of each vet in the clinic")
    public void shouldSeeTheNameOfEachVetInTheClinic(Actor actor) {
        actor.attemptsTo(
                Ensure.that(DisplayedVet.names()).hasSize(6)
        );
    }

    @DataTableType
    public Veterinarian vetEntry(Map<String, String> entry) {
        return new Veterinarian(entry.get("Name"), specialitiesIn(entry.get("Specialities")));
    }

    private List<String> specialitiesIn(String specialityList) {
        if (specialityList == null)
        { return new ArrayList<>(); }
        return Splitter.on(",").trimResults().splitToList(specialityList);
    }

    @Then("{actor} should see each of the following vet specialities")
    public void shouldSeeVetSpecialities(Actor actor, List<Veterinarian> vetSpecialities) {
        vetSpecialities.forEach(
                veterinarian -> {
                    Collection<String> specialities = DisplayedVet.specialitiesFor(veterinarian.getName())
                            .answeredBy(actor);
                    assertThat(specialities).containsExactlyElementsOf(
                            veterinarian.getSpecialities()
                    );
                }
        );
    }
}
