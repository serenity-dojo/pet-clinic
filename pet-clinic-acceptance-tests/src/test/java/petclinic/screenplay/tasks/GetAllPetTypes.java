package petclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetAllPetTypes implements Task{
    private EnvironmentVariables environmentVariables;
    private static String theRestApiBaseUrl;

    public static GetAllPetTypes available(){
        return instrumented(GetAllPetTypes.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/pettypes")
        );
    }
}
