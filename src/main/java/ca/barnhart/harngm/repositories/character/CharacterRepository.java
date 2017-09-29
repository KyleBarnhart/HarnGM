package ca.barnhart.harngm.repositories.character;

import ca.barnhart.harngm.entities.character.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_PLAYER')")
public interface CharacterRepository extends CrudRepository<Character, Integer> {

    @Override
    @PreAuthorize("#character?.player == null or #character?.player?.name == authentication?.name")
    Character save(@Param("character") Character character);

    @Override
    @PreAuthorize("@characterRepository.findOne(#id)?.player?.name == authentication?.name")
    void delete(@Param("id") Integer id);

    @Override
    @PreAuthorize("#character?.player?.name == authentication?.name")
    void delete(@Param("character") Character character);
}
