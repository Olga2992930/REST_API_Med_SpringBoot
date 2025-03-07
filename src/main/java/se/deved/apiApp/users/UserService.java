package se.deved.apiApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import se.deved.apiApp.users.UserEntity;
import se.deved.apiApp.users.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}



