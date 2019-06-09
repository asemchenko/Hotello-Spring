package company.example.service;

import company.example.model.entity.User;
import company.example.model.entity.UserRole;
import company.example.model.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean isAdmin(String username) {
        return userRepo.findByUsername(username).getRole() == UserRole.ADMIN;
    }

    public User save(User user) {
        return userRepo.save(user);
    }
}