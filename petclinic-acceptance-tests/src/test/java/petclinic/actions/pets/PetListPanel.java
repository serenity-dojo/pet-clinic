package petclinic.actions.pets;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

class PetListPanel {
    static final Target PET_TYPES = Target.the("List of pets")
            .located(By.cssSelector("input[name='pettype_name']"));
}
