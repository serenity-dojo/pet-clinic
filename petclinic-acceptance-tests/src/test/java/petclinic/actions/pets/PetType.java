package petclinic.actions.pets;

public class PetType {
    private final String name;
    private final Integer id;

    public PetType(Integer id,String name) {
        this.name = name;
        this.id = id;
    }

    public static PetType named(String name) {
        return new PetType(null, name);
    }
}
