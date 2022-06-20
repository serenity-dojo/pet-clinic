package petclinic.screenplay.tasks.pets;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetAllPetTypes implements Task{
    private EnvironmentVariables environmentVariables;
    private static String theRestApiBaseUrl;

    public static GetAllPetTypes available(){
        return instrumented(GetAllPetTypes.class);
    }

    @Override
    @Step("{0} checks available pet types via na api request")
    public <T extends Actor> void performAs(T actor) {
        theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.service.url");
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/pettypes")
        );
    }
}
