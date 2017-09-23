package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BodyPartCategory {
    @Id
    private String code;
    private String name;

    public BodyPartCategory() {}

    public BodyPartCategory(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
