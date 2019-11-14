package gt.edu.umg.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.umg.demo.model.TcUser;
import gt.edu.umg.demo.repository.TcUserRepository;

@Service
public class TcUserDetailsService implements UserDetailsService {

    @Autowired
    TcUserRepository tcUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TcUser tcUser = tcUserRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found: " + username)
        );
        return UserPrinciple.build(tcUser);
    }
}