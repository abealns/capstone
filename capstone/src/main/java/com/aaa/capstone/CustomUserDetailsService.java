package com.aaa.capstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepo;
     
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        user User = ((UserRepository) userRepo).findByEmail(userName);
        if (User == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(User);
    }
 
}