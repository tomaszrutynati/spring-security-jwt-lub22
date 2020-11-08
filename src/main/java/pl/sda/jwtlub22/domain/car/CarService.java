package pl.sda.jwtlub22.domain.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//TYLKO PRZELOTKA, NIE MA ZADNEJ LOGIKI BIZNESOWEJ
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void create(Car car) {
        carRepository.create(car);
    }
    public void update(Car car) {
        carRepository.update(car);
    }
    public void delete(String id) {
        carRepository.delete(id);
    }
    public Optional<Car> getById(String id) {
        return carRepository.getById(id);
    }
    public List<Car> getAll() {
        return carRepository.getAll();
    }
}
