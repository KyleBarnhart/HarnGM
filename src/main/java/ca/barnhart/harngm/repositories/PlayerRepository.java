package ca.barnhart.harngm.repositories;

import ca.barnhart.harngm.entities.Player;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface PlayerRepository extends Repository<Player, Long> {
    Player save(Player player);
    Player findByName(String name);
}
