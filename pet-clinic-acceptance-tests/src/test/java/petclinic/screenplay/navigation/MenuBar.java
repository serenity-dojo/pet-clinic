package petclinic.screenplay.navigation;

import net.serenitybdd.screenplay.targets.Target;

public class MenuBar {
    public static final Target PET_TYPES = Target.the("Pet Types menu").locatedBy("//span[text()='Pet Types']");
    public static final Target VETERINARIANS = Target.the("Veterinarians menu").locatedBy("//li[a[contains(text(),'Veterinarians')]]/a");
    public static final Target ALL_VETERINARIANS = Target.the("All button").locatedBy("//li[a[contains(text(),'Veterinarians')]]//span[contains(text(),'All')]");
}
