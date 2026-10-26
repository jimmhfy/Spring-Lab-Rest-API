package example.cashcard;

import org.jspecify.annotations.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class AppUserDetailService implements UserDetailsService {
    UserRepository userRepository;

    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) {
        Customer customer = Optional.of(userRepository.findUserByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(
                customer.username(),
                customer.password(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
