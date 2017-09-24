package ca.barnhart.harngm.repositories;

import ca.barnhart.harngm.entities.character.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
}
