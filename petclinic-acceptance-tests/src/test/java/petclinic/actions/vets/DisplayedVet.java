package petclinic.actions.vets;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class DisplayedVet {
    public static Question<Collection<String>> names() {
        return Text.of(VetList.VET_NAMES).asAList();
    }

    public static Question<Collection<String>> specialitiesFor(String vetName) {
        return Text.of(VetList.SPECIALITIES_FOR_VET.of(vetName)).asAList();
    }
}
