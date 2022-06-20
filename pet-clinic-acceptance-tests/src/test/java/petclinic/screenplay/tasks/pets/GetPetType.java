package petclinic.screenplay.tasks.pets;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPetType implements Task{
    private final int id;

    public GetPetType(int id) {
        this.id = id;
    }

    public static GetPetType withId(int id) {
        return instrumented(GetPetType.class, id);
    }

    @Override
    @Step("{0} fetches the animal type with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pettypes/{id}")
                        .with(request -> request.pathParam("id", id))
        );
    }
}
