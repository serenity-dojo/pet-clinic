package petclinic.screenplay.tasks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPetType implements Task{
    private final int id;
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;

    public GetPetType(int id) {
        this.id = id;
    }

    public static GetPetType withId(int id) {
        return instrumented(GetPetType.class, id);
    }

    @Override
    @Step("{0} fetches the animal type with id #id")
    public <T extends Actor> void performAs(T actor) {
        theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.service.url");
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/pettypes/{id}")
                        .with(request -> request.pathParam("id", id))
        );
    }
}
