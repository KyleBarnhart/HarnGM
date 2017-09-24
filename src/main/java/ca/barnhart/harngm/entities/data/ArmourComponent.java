package ca.barnhart.harngm.entities.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ArmourComponent {
    @Id
    @Column(length = 16)
    private String keyword;

    private String name;

    private String description;

    @ManyToOne
    private BodyPartCategory category;

    @ManyToMany
    private Set<BodyPart> bodyParts;

    @ManyToMany
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
