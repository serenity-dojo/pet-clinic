package petclinic.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import petclinic.actions.navigation.Navigate;

public class NavigationStepDefinitions {
    @Given("{actor} is a {}")
    public void aPetClinicOwner(Actor actor, String role) {
        actor.describedAs(role);
        actor.attemptsTo(
                Navigate.toTheApplicationHomePage()
        );
    }
}
