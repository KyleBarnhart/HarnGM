package ca.barnhart.harngm.entities.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity
public class Material {
    @Id
    @Column(length = 16)
    private String keyword;

    private String name;

    @ElementCollection(targetClass = Integer.class)
    @MapKeyClass(Aspect.class)
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
