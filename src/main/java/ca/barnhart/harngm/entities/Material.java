package ca.barnhart.harngm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;
import java.util.Set;

@Data
@Entity
public class Material {
    @Id
    private String keyword;
    private String name;
    private Map<Aspect, Integer> aspectValues;
    private Integer weight;
    private Integer price;

    public Material() {}

    public Material(String keyword, String name, Map<Aspect, Integer> aspectValues, Integer weight, Integer price) {
        this.keyword = keyword;
        this.name = name;
        this.aspectValues = aspectValues;
        this.weight = weight;
        this.price = price;
    }
}
