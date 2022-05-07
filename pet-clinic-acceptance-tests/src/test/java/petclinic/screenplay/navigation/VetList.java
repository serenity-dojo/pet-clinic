package petclinic.screenplay.navigation;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VetList {
    public static final Target VET_NAMES = Target.the("List of vets")
            .located(By.cssSelector("#vets tbody tr td:nth-child(1)"));
}
