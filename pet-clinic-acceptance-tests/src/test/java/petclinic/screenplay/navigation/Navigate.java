package petclinic.screenplay.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {
    public static Performable toTheVetApplicationHomePage() {
        return Open.url("http://localhost:8080/petclinic/");
    }

    public static Performable toTheVeterinariansList() {
        return Click.on(MenuBar.VETERINARIANS).then(Click.on(MenuBar.ALL_VETERINARIANS));
            }
}
