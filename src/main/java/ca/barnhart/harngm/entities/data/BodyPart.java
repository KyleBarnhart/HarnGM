package ca.barnhart.harngm.entities.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class BodyPart {
    @Id
    @Column(length = 5)
    private String code;

    private String name;

    @ManyToOne
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
