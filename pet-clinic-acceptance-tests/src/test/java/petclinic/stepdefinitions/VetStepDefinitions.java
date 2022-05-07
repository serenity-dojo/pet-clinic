package petclinic.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.devtools.v95.page.Page;
import petclinic.screenplay.navigation.Navigate;
import petclinic.screenplay.questions.DisplayedVet;


public class VetStepDefinitions {
    @Given("{actor} is a Pet Clinic owner")
    public void peterIsAPetClinicOwner(Actor actor) {
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
    public void heShouldSeeTheNameOfEachVetInTheClinic(Actor actor) {
        actor.attemptsTo(
                Ensure.that(DisplayedVet.names()).contains("James Carter")
        );
    }
}
