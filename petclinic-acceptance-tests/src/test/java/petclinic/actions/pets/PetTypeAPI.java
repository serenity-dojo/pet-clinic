package petclinic.actions.pets;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.List;

public class PetTypeAPI {

    private static List<Integer> createdPetTypeIds = new ArrayList<>();

    public static void savePetTypes(List<String> petTypes) {
        petTypes.forEach(
                petType -> postPetTypeWithName(petType)
        );
    }

    private static void postPetTypeWithName(String petTypeName) {
        Integer petTypeId = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(PetType.named(petTypeName))
                .post("http://localhost:9966/petclinic/api/pettypes")
                .jsonPath().getInt("id");

        createdPetTypeIds.add(petTypeId);
    }

    public static void clearCreatedPetTypes() {
        createdPetTypeIds.forEach(
                petTypeId -> RestAssured.delete("http://localhost:9966/petclinic/api/pettypes/{petTypeId}", petTypeId)
        );
        createdPetTypeIds.clear();
    }
}
