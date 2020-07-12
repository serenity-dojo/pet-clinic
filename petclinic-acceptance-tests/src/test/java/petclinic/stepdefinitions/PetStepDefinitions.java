package petclinic.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import petclinic.actions.navigation.Navigate;
import petclinic.actions.pets.PetTypes;

import java.util.List;

import static net.serenitybdd.assertions.CollectionMatchers.containsAll;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PetStepDefinitions {

    @When("{actor} views the different types of pets that can be treated")
    public void viewsThePetTypes(Actor actor) {
        actor.attemptsTo(
                Navigate.toThePetTypes()
        );
    }

    @Then("{actor} should see at least the following:")
    public void shouldSeeTheNameAndSpecialitiesOfEachVet(Actor actor, List<String> petTypes) {
        actor.should(
                seeThat("the list of pet types", PetTypes.displayed(), containsAll(petTypes))
        );
    }
}
