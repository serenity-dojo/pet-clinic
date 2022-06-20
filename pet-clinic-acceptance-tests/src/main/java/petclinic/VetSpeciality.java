package petclinic;

import java.util.HashMap;
import java.util.Map;

public enum VetSpeciality {
    RADIOLOGY("1"), SURGERY("2"), DENTISTRY("3");

    private static final Map<String, VetSpeciality> BY_LABEL = new HashMap<>();
    private final String id;

    VetSpeciality(String id) {
        this.id = id;
    }

    static {
        for (VetSpeciality speciality: values()) {
            BY_LABEL.put(speciality.id, speciality);
        }
    }

    public static VetSpeciality valueOfLabel(String id) {
        return BY_LABEL.get(id);
    }
}
