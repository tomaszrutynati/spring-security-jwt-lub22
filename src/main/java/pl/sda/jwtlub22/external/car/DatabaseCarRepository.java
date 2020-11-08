package pl.sda.jwtlub22.external.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.jwtlub22.domain.car.Car;
import pl.sda.jwtlub22.domain.car.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseCarRepository implements CarRepository {
    private final MongoCarRepository mongoCarRepository;

    @Override
    public void create(Car car) {
        CarDocument carDocument = CarDocument.builder()
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .build();
        mongoCarRepository.save(carDocument);
    }

    @Override
    public void update(Car car) {
        CarDocument carDocument = CarDocument.builder()
                .id(car.getId())
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .build();
        mongoCarRepository.save(carDocument);
    }

    @Override
    public void delete(String id) {
        mongoCarRepository.deleteById(id);
    }

    @Override
    public Optional<Car> getById(String id) {
        return mongoCarRepository.findById(id)
                .map(ent -> new Car(ent.getId(),
                        ent.getManufacturer(), ent.getModel()));
    }

    @Override
    public List<Car> getAll() {
        return mongoCarRepository.findAll().stream()
                .map(ent -> new Car(ent.getId(),
                        ent.getManufacturer(), ent.getModel()))
                .collect(Collectors.toList());
    }
}
