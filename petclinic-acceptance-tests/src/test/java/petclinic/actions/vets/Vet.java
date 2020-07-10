package petclinic.actions.vets;

import java.util.List;

public class Vet {
    private String name;
    private List<String> specialities;

    public Vet(String name, List<String> specialities) {
        this.name = name;
        this.specialities = specialities;
    }

    public String getName() {
        return name;
    }

    public List<String> getSpecialities() {
        return specialities;
    }
}
