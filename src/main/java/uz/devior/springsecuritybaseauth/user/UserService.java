package uz.devior.springsecuritybaseauth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.devior.springsecuritybaseauth.shared.Role;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       if(!username.equals("Odilhon")) throw new UsernameNotFoundException("User not found");

       Set<Role> roles = new HashSet<>();
       Role role = new Role();
       role.setAuthority("USER");
       roles.add(role);

       User user = new User();
       user.setUsername("Odilhon");
       user.setPassword(passwordEncoder.encode("password"));
       user.setAuthorities(roles);

       return user;
    }
}
