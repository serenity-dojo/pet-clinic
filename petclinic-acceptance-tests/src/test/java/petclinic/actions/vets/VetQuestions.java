package petclinic.actions.vets;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class VetQuestions {
    private static final Target VET_NAMES = Target.the("List of vets")
            .locatedBy("#vets tbody tr td:nth-child(1)");

    private static final Target SPECIALITIES_FOR_VET = Target.the("specialities")
            .locatedBy("//tr[contains(td,'{0}')]/td[2]/div");

    public static Question<List<String>> vetNamesDisplayed() {
        return actor -> Text.of(VET_NAMES).viewedBy(actor).asList();
    }

    public static Question<List<String>> specialitiesFor(String vetName) {
        return actor -> Text.of(SPECIALITIES_FOR_VET.of(vetName)).viewedBy(actor).asList();
    }
}
