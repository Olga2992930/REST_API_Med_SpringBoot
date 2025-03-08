package se.deved.apiApp.users;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import java.util.Optional;
import se.deved.apiApp.users.UserEntity;
import se.deved.apiApp.users.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserEntity saveOrUpdateUser(OAuth2User oAuth2User) {
        String githubId = oAuth2User.getAttribute("id").toString();
        String username = oAuth2User.getAttribute("login");

        return userRepository.findByOidcId(githubId).orElseGet(() -> {
            UserEntity newUser = new UserEntity();
            newUser.setOidcId(githubId);
            newUser.setUsername(username);
            return userRepository.save(newUser);
        });
    }
}



