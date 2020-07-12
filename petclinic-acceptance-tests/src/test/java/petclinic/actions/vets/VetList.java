package petclinic.actions.vets;

import net.serenitybdd.screenplay.targets.Target;

class VetList {

    static final Target VET_NAMES = Target.the("List of vets")
            .locatedBy("#vets tbody tr td:nth-child(1)");

    static final Target SPECIALITIES_FOR_VET = Target.the("specialities")
            .locatedBy("//tr[contains(td,'{0}')]/td[2]/div");

}
