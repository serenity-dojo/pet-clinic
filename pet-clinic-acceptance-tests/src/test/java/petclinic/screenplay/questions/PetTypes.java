package petclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;

import java.util.Collection;

import static petclinic.screenplay.navigation.PetList.PET_TYPES;

public class PetTypes {

    public static Question<Collection<String>> displayed() {
        return Value.ofEach(PET_TYPES);
    }
}
