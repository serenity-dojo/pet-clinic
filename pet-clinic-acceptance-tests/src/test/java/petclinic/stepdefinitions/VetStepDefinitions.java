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
import petclinic.screenplay.tasks.vets.GetVet;
//import petclinic.screenplay.tasks.vets.VetSpeciality;
import petclinic.screenplay.tasks.pets.GetAllPetTypes;
import petclinic.screenplay.tasks.pets.GetPetType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;

public class VetStepDefinitions {







    @When("{actor} checks available Pet Types")
    public void heChecksIfCatIsAvailableAsAPetTypes(Actor actor) {
        actor.attemptsTo(
                GetAllPetTypes.available()
        );
    }

    @Then("{actor} should see the pet types")
    public void thePetTypeShouldBeDisplayed(Actor actor) {
        actor.should(seeThatResponse("Animal type is returned",
                response -> response.statusCode(200)));
    }

    @Given("{actor} checks if cat can be submitted to the clinic")
    public void catIsAddedAsAPetType(Actor actor) {
        actor.attemptsTo(
                GetPetType.withId(1)
        );
    }

    @Then("{actor} should receive a confirmation")
    public void itShouldBeConfirmed(Actor actor) {
        actor.should(seeThatResponse("Animal type is returned",
                response -> response.statusCode(200)));
    }


    @Given("{actor} {word} is an employed vet that specializes in {word}")
    public void helenIsAnEmployedVetThatSpecializesInRadiology(Actor actor, String lastName, String speciality) {
//        Veterinarian newVet = Veterinarian.builder()
//                                .firstName(actor.getName())
//                                .lastName(lastName)
//                                .specialities(speciality)
//                                .build();
//
//       actor.attemptsTo(CreateVet.withFirstAndLastName(newVet));
//        String vetID = SerenityRest.lastResponse().jsonPath().getString("id");
//        actor.attemptsTo(GetVet.data(vetID));
//        actor.attemptsTo(VetSpeciality.addNewSpeciality(vetID, speciality));

        actor.attemptsTo(GetVet.data("2"));
    }

    @When("{actor} checks his/her speciality")
    public void peterChecksHerSpeciality(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheVetApplicationHomePage(),
                Navigate.toTheVeterinariansList()
        );
    }

    @Then("{actor} should see that her speciality is {word}")
    public void heShouldSeeThatHerSpecialityIsRadiology(Actor actor, String speciality) {
        actor.attemptsTo(Ensure.that(DisplayedVet.singleSpeciality()).contains(speciality));
    }

    @Given("{actor} is an employed vet that specializes in dentistry and surgery")
    public void lindaIsAnEmployedVetThatSpecializesInDentistryAndSurgery(Actor actor) {
        actor.attemptsTo(GetVet.data("3"));
    }

    @Then("{actor} should see that she has two specialities")
    public void heShouldSeeThatSheHasTwoSpecialities(Actor actor) {
        actor.attemptsTo(Ensure.that(DisplayedVet.doubleSpeciality()).contains("dentistry"));
    }

    @Given("{actor} is an employed vet without any specific speciality")
    public void jamesIsAnEmployedVetWithoutAnySpecificSpeciality(Actor actor) {
        actor.attemptsTo(GetVet.data("1"));
    }

    @Then("{actor} should see that James has no speciality specified")
    public void heShouldSeeThatJamesHasNoSpecialitySpecified(Actor actor) {
        actor.attemptsTo(Ensure.that(DisplayedVet.noSpeciality()).isEmpty());
    }


}
