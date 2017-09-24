package ca.barnhart.harngm.repositories;

import ca.barnhart.harngm.entities.data.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material, Integer> {
}
