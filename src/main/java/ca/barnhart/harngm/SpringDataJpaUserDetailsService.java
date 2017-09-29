package ca.barnhart.harngm;

import ca.barnhart.harngm.entities.Player;
import ca.barnhart.harngm.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final PlayerRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Player player = this.repository.findByName(name);
        return new User(player.getName(), player.getPassword(),
                AuthorityUtils.createAuthorityList(player.getRoles()));
    }

}