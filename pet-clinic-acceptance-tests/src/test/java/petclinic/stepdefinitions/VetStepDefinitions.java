package petclinic.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import petclinic.screenplay.navigation.Navigate;
import petclinic.screenplay.questions.DisplayedVet;
import petclinic.screenplay.tasks.GetAllPetTypes;
import petclinic.screenplay.tasks.GetPetType;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


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
}
