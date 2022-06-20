package petclinic;

import lombok.Data;

@Data
public class PetType {
    private final String name;
    private final Integer id;

    private PetType(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public static PetType named(String name) {
        return new PetType(null, name);
    }
}
