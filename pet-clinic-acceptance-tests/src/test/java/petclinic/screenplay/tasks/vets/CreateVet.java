package petclinic.screenplay.tasks.vets;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import petclinic.Veterinarian;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateVet implements Task{
    private final Veterinarian vet;

    public CreateVet(Veterinarian vet) {
        this.vet = vet;
    }

    public static CreateVet withFirstAndLastName(Veterinarian vet){
        return instrumented(CreateVet.class, vet);
    }

    @Override
    @Step("{0} is created via an api request")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/vets")
                        .with(request -> request.body(vet))
        );
    }
}
