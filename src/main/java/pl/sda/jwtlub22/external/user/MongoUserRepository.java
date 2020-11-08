package pl.sda.jwtlub22.external.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<UserDocument, String> {

    Optional<UserDocument> findByUsername(String username);
}
