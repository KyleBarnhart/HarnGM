package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Armour {
    @Id @GeneratedValue
    private Integer id;
    private ArmourComponent component;
    private Material material;
    private ArmourQuality quality;

    public Armour() {}

    public Armour(ArmourComponent component, Material material, ArmourQuality quality) {
        this.component = component;
        this.material = material;
        this.quality = quality;
    }

    public Integer getModifiedPrice() {
        if(material == null || material.getPrice() == null || quality == null || quality.getPercentChangePrice() == null) {
            return null;
        }

        return Math.round(material.getPrice() * quality.getPercentChangePrice() / 100.0f);
    }

    public Integer getModifiedWeight() {
        if(material == null || material.getWeight() == null || quality == null || quality.getPercentChangeWeight() == null) {
            return null;
        }

        return Math.round(material.getWeight() * quality.getPercentChangeWeight() / 100.0f);
    }
}
