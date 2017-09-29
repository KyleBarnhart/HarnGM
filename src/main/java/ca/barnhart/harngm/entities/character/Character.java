package ca.barnhart.harngm.entities.character;

import ca.barnhart.harngm.entities.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Character {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private Player player;

//    @OneToMany
//    private Set<Armour> armour;

    @Version
    @JsonIgnore
    private Long version;

    private Character() {}

    public Character(String name, Player player) {
        this.name = name;
        this.player = player;
    }
}
