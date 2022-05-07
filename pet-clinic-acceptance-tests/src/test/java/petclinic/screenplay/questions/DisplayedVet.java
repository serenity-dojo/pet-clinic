package petclinic.screenplay.questions;

import io.cucumber.java.an.E;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;
import petclinic.screenplay.navigation.VetList;
import java.util.Collection;
import java.util.List;

public class DisplayedVet {
    private static Class<Task> Vets;

    public static Question<Collection<String>> names() {
        return Text.ofEach(VetList.VET_NAMES);
    }



}
