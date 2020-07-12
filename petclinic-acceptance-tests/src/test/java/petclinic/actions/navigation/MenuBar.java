package petclinic.actions.navigation;

import net.serenitybdd.screenplay.targets.Target;

public class MenuBar {
    public static Target VETERINARIANS
            = Target.the("Veterinarians menu")
            .locatedBy("//li[a[contains(text(),'Veterinarians')]]/a");

    public static Target ALL_VETERINARIANS
            = Target.the("All")
            .locatedBy("//li[a[contains(text(),'Veterinarians')]]//span[contains(text(),'All')]");
}
