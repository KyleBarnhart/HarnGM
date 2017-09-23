package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Aspect {
    @Id
    private String code;
    private String name;

    public Aspect() {}

    public Aspect(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
