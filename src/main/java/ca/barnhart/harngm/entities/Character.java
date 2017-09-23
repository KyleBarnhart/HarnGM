package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Data
@Entity
public class Character {
    private @Id @GeneratedValue Integer id;
    private String name;
    private Set<Armour> armour;

    private Character() {}

    public Character(String name) {
        this.name = name;
    }
}
