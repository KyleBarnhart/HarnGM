package ca.barnhart.harngm.repositories.data;

import ca.barnhart.harngm.entities.data.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material, String> {
}
