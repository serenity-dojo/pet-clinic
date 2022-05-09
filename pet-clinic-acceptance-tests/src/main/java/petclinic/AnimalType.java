package petclinic;

import jdk.nashorn.internal.objects.annotations.Getter;


public class AnimalType {
    private int id;
    private String animalType;

    public AnimalType(int id, String animalType) {
        this.id = id;
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public int getId() {
        return id;
    }
}
