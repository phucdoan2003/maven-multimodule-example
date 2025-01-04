package sead.assignment2.auth.internal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sead.assignment2.external.service.ExternalUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ExternalUserService service;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        try {
            return service.getUserById(Long.parseLong(id));
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
