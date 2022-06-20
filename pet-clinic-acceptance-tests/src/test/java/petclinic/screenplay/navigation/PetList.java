package petclinic.screenplay.navigation;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PetList {
    public static final Target PET_TYPES = Target.the("List of pet types")
            .located(By.xpath("//input[@name='pettype_name']"));
}
