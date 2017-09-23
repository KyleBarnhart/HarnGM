package ca.barnhart.harngm.repositories;

import ca.barnhart.harngm.entities.BodyPart;
import org.springframework.data.repository.CrudRepository;

public interface BodyPartRepository extends CrudRepository<BodyPart, Integer> {
}