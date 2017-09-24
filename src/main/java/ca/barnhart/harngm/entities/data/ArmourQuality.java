package ca.barnhart.harngm.entities.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ArmourQuality {
    @Id
    private Integer quality;

    private Integer percentChangePrice;

    private Integer percentChangeWeight;

    public ArmourQuality() {}

    public ArmourQuality(Integer quality, Integer percentChangePrice, Integer percentChangeWeight) {
        this.quality = quality;
        this.percentChangePrice = percentChangePrice;
        this.percentChangeWeight = percentChangeWeight;
    }
}
