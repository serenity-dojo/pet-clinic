package petclinic.actions.pets;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

import java.util.Collection;

import static petclinic.actions.pets.PetListPanel.PET_TYPES;

public class PetTypes {
    public static Question<Collection<String>> displayed() {
        return Value.of(PET_TYPES).asAList();
    }
}
