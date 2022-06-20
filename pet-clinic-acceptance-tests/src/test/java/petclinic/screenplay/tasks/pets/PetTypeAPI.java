package petclinic.screenplay.tasks.pets;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import petclinic.PetType;
import java.util.ArrayList;
import java.util.List;


public class PetTypeAPI {

    private static List<Integer> createdPetTypeIds = new ArrayList<>();

    public static void addPetType(List<String> petTypes) {
        petTypes.forEach(
                pet -> addNewPetType(pet)
        );
    }

    private static void addNewPetType(String pet) {
        Integer petTypeId = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(PetType.named(pet))
                .post("http://localhost:9966/petclinic/api/pettypes")
                .jsonPath().getInt("id");

        createdPetTypeIds.add(petTypeId);
    }

    public static void clearCreatedPetTypes() {
        createdPetTypeIds.forEach(
                petTypeId -> SerenityRest.delete
                        ("http://localhost:9966/petclinic/api/pettypes/{petTypeId}", petTypeId)
        );
        createdPetTypeIds.clear();
    }
}



