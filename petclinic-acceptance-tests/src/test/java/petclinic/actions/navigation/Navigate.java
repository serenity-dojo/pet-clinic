package petclinic.actions.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {

    public static Performable toTheApplicationHomePage() {
        return Open.url("http://localhost:8080/petclinic");
    }

    public static Performable toTheVeterinarianList() {
        return Click.on(MenuBar.VETERINARIANS).then(Click.on(MenuBar.ALL_VETERINARIANS));
    }

    public static Performable toThePetTypes() {
        return Click.on(MenuBar.PET_TYPES);
    }
}
