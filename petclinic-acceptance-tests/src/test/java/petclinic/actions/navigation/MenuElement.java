package petclinic.actions.navigation;

import net.serenitybdd.screenplay.targets.Target;

public class MenuElement {
    private final static String TOP_LEVEL_MENU_ITEM = "//li[a[contains(text(),'%s')]]/a";
    private final static String NESTED_MENU_ITEM = "//li[a[contains(text(),'%s')]]//span[contains(text(),'%s')]";

    static Target topLevelMenu(String label) {
        String locator = String.format(TOP_LEVEL_MENU_ITEM, label);
        return Target.the("'" + label + "' menu").locatedBy(locator);
    }

    static Target nestedMenu(String topLevelItem, String nestedItem) {
        String locator = String.format(NESTED_MENU_ITEM, topLevelItem, nestedItem);
        return Target.the("'" + nestedItem + "' menu").locatedBy(locator);
    }
}
