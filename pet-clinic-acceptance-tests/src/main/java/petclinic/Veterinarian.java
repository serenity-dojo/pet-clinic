package petclinic;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Veterinarian {
    private String name;
    private List<String> specialities;

    public Veterinarian(String name, List<String> specialities) {
        this.name = name;
        this.specialities = specialities;
    }
}
