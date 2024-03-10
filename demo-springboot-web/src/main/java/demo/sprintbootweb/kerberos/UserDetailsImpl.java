package demo.sprintbootweb.kerberos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.ArrayList;

public class UserDetailsImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        List<GrantedAuthority> authorityList = new ArrayList<>();
        return new User("jeff","",authorityList);
    }

}
