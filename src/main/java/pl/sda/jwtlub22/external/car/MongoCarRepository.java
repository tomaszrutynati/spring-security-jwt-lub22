package pl.sda.jwtlub22.external.car;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoCarRepository extends MongoRepository<CarDocument, String> {
}
