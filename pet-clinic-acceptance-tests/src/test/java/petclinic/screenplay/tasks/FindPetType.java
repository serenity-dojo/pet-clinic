package petclinic.screenplay.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;



public class FindPetType implements Task{
    private final int id;
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;

    public FindPetType(int id) {
        this.id = id;
    }

    public static FindPetType withId(int id) {
        return instrumented(FindPetType.class, id);
    }

    @Override
    @Step("{0} fetches the animal type with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/pettypes/{id}")
                        .with(request -> request.pathParam("id", id))
        );
    }
}
