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
    private final JpaCarRepository jpaCarRepository;

    @Override
    public void create(Car car) {
        CarEntity carEntity = CarEntity.builder()
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .build();
        jpaCarRepository.save(carEntity);
    }

    @Override
    public void update(Car car) {
        CarEntity carEntity = CarEntity.builder()
                .id(car.getId())
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .build();
        jpaCarRepository.save(carEntity);
    }

    @Override
    public void delete(Long id) {
        jpaCarRepository.deleteById(id);
    }

    @Override
    public Optional<Car> getById(Long id) {
        return jpaCarRepository.findById(id)
                .map(ent -> new Car(ent.getId(),
                        ent.getManufacturer(), ent.getModel()));
    }

    @Override
    public List<Car> getAll() {
        return jpaCarRepository.findAll().stream()
                .map(ent -> new Car(ent.getId(),
                        ent.getManufacturer(), ent.getModel()))
                .collect(Collectors.toList());
    }
}
