package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BodyPart {
    @Id
    private String code;
    private String name;
    private BodyPartCategory category;
    private Integer percentSurfaceCoverage;

    public BodyPart() {}

    public BodyPart(String code, String name, BodyPartCategory category, Integer percentSurfaceCoverage) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.percentSurfaceCoverage = percentSurfaceCoverage;
    }
}
