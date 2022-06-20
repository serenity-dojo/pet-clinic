package petclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;
import petclinic.Veterinarian;
import petclinic.screenplay.navigation.VetList;
import java.util.Collection;

public class DisplayedVet {
    private static Class<Task> Vets;

    public static Question<Collection<String>> names() {
        return Text.ofEach(VetList.VET_NAMES);
    }

    public static Question<String> singleSpeciality() {
        return Text.of(VetList.HELEN_SPECIALITY);
    }

    public static Question<Collection<String>> doubleSpeciality() {
        return Text.ofEach(VetList.LINDA_SPECIALITY);
    }

    public static Question<String> noSpeciality() {
        return Text.of(VetList.JAMES_SPECIALITY);
    }

    public static Question<Collection<String>> specialitiesFor(String vetName) {
        return Text.ofEach(VetList.SPECIALITIES_FOR_VET.of(vetName));
    }
}
