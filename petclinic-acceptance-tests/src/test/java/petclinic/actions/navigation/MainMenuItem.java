package petclinic.actions.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static petclinic.actions.navigation.MenuElement.nestedMenu;
import static petclinic.actions.navigation.MenuElement.topLevelMenu;

public enum MainMenuItem {
    ALL_VETERINARIANS(
            Click.on(topLevelMenu("Veterinarians"))
                    .then(Click.on(nestedMenu("Veterinarians","All")))
    ),
    ADD_NEW_VET(
            Click.on(topLevelMenu("Veterinarians"))
                    .then(Click.on(nestedMenu("Veterinarians","Add New")))
    ),
    PET_TYPES(
            Click.on(topLevelMenu("Pet Types"))
    );

    private final Performable selectMenuAction;

    MainMenuItem(Performable selectMenuAction) {
        this.selectMenuAction = selectMenuAction;
    }

    public Performable selectMenuItem() {
        return selectMenuAction;
    }
}
