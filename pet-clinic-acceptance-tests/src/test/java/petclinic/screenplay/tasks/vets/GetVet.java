package petclinic.screenplay.tasks.vets;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetVet implements Task {
    private final String id;

    public GetVet(String id) {
        this.id = id;
    }

    public static GetVet data(String id) {
        return instrumented(GetVet.class, id);
    }

    @Override
    @Step("{0} employee data is received via an api request")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/vets/{id}")
                        .with(request -> request.pathParam("id", id)
        ));
    }
}
