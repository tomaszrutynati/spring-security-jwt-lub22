package pl.sda.jwtlub22.domain.car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    void create(Car car);
    void update(Car car);
    void delete(String id);
    Optional<Car> getById(String id);
    List<Car> getAll();

}
