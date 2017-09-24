package ca.barnhart.harngm.entities.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Aspect {
    @Id
    @Column(length = 1)
    private String code;

    private String name;

    public Aspect() {}

    public Aspect(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
