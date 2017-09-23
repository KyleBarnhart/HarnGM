package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Data
@Entity
public class ArmourComponent {
    @Id
    private String keyword;
    private String name;
    private String description;
    private BodyPartCategory category;
    private Set<BodyPart> bodyParts;
    private Set<Material> materials;

    public ArmourComponent() {}

    public ArmourComponent(String keyword, String name, String description, BodyPartCategory category, Set<BodyPart> bodyParts, Set<Material> materials) {
        this.keyword = keyword;
        this.name = name;
        this.description = description;
        this.category = category;
        this.bodyParts = bodyParts;
        this.materials = materials;
    }
}
