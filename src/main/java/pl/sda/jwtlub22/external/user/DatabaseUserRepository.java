package pl.sda.jwtlub22.external.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.jwtlub22.domain.user.User;
import pl.sda.jwtlub22.domain.user.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseUserRepository implements UserRepository {

    private final MongoUserRepository mongoUserRepository;

    @Override
    public void create(User user) {
        UserDocument entity = UserDocument.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        mongoUserRepository.save(entity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return mongoUserRepository.findByUsername(username)
                .map(ent -> new User(ent.getId(), ent.getUsername(),
                        ent.getPassword(), ent.getRole()));
    }
}
