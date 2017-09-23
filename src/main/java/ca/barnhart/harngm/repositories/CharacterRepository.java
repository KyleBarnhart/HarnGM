package ca.barnhart.harngm.repositories;

import ca.barnhart.harngm.entities.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
}
