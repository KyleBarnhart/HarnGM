package ca.barnhart.harngm.events;

import ca.barnhart.harngm.entities.Player;
import ca.barnhart.harngm.entities.character.Character;
import ca.barnhart.harngm.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static ca.barnhart.harngm.WebSocketConfiguration.MESSAGE_PREFIX;

@Component
@RepositoryEventHandler(Character.class)
public class CharacterEventHandler {
    private final SimpMessagingTemplate websocket;
    private final EntityLinks entityLinks;

    private final PlayerRepository playerRepository;

    @Autowired
    public CharacterEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks, PlayerRepository playerRepository) {
        this.websocket = websocket;
        this.entityLinks = entityLinks;
        this.playerRepository = playerRepository;
    }

    @HandleBeforeCreate
    public void applyUserInformationUsingSecurityContext(Character character) {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Player player = this.playerRepository.findByName(name);
        if (player == null) {
            Player newPlayer = new Player();
            newPlayer.setName(name);
            newPlayer.setRoles(new String[]{"ROLE_PLAYER"});
            player = this.playerRepository.save(newPlayer);
        }
        character.setPlayer(player);
    }

    @HandleAfterCreate
    public void newEmployee(Character character) {
        this.websocket.convertAndSend(MESSAGE_PREFIX + "/newCharacter", getPath(character));
    }

    @HandleAfterDelete
    public void deleteEmployee(Character character) {
        this.websocket.convertAndSend(MESSAGE_PREFIX + "/deleteCharacter", getPath(character));
    }

    @HandleAfterSave
    public void updateEmployee(Character character) {
        this.websocket.convertAndSend(MESSAGE_PREFIX + "/updateCharacter", getPath(character));
    }

    /**
     * Take an {@link Character} and get the URI using Spring Data REST's {@link EntityLinks}.
     *
     * @param character
     */
    private String getPath(Character character) {
        return this.entityLinks
                .linkForSingleResource(character.getClass(), character.getId())
                .toUri()
                .getPath();
    }
}
