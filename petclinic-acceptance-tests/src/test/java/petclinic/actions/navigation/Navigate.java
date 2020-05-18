package petclinic.actions.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {

    public static Performable toTheApplicationHomePage() {
        return Task.where("{0} opens the PetClinic application",
                Open.browserOn().the(PetClinicHomePage.class)
        );
    }

    public static Performable to(MainMenuItem menuItem) {
        return Task.where("{0} navigates to the " + menuItem + " page", menuItem.selectMenuItem());
    }
}
