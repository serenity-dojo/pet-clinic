package petclinic.screenplay.navigation;

import com.google.common.base.Optional;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VetList {
    public static final Target VET_NAMES = Target.the("List of vets")
            .located(By.cssSelector("#vets tbody tr td:nth-child(1)"));

    public static final Target HELEN_SPECIALITY = Target.the("Helen Leary speciality")
            .located(By.xpath("//table[@id='vets']//tr[contains(.,'Helen Leary')]/td/div"));

    public static final Target LINDA_SPECIALITY = Target.the("Linda Douglas specialities")
            .located(By.xpath("//*[@id='vets']/tbody/tr[3]/td[2]"));

    public static final Target JAMES_SPECIALITY = Target.the("James Carter speciality")
            .located(By.xpath("//*[@id='vets']/tbody/tr[1]/td[2]"));
    public static final Target SPECIALITIES_FOR_VET = Target.the("specialities")
            .locatedBy("//tr[contains(td,'{0}')]/td[2]/div");
}
