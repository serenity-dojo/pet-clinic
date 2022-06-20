package petclinic.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import petclinic.AnimalType;
import petclinic.screenplay.navigation.Navigate;
import petclinic.screenplay.questions.PetTypes;
import petclinic.screenplay.tasks.pets.PetTypeAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTypesData {
    @When("{actor} views the different types of pets that can be treated")
    public void viewsTheDifferentTypesOfPetsThatCanBeTreated(Actor actor) {
        actor.attemptsTo(
                Navigate.toThePetTypes()
        );
    }

    @Then("{actor} should see at least the following:")
    public void shouldSeeAtLeastTheFollowing(Actor actor, List<String> petTypes) {
        petTypes.forEach(
                petType -> {
                    Collection<String> types = PetTypes.displayed().answeredBy(actor);
                    assertThat(String.valueOf(types)).contains(
                            String.valueOf(Arrays.asList(AnimalType.values())).toLowerCase()
                    );
                }
        );
    }

    @Given("the vet clinic caters for the following pet types:")
    public void theVetClinicCatersForTheFollowingPetTypes(List<String> petTypes) {
        PetTypeAPI.addPetType(petTypes);
    }
}
