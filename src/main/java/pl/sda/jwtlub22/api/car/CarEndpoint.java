package pl.sda.jwtlub22.api.car;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.jwtlub22.domain.car.Car;
import pl.sda.jwtlub22.domain.car.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarEndpoint {

    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createCar(@RequestBody Car car) {
        carService.create(car);
    }

    @PutMapping
    void update(@RequestBody Car car) {
        carService.update(car);
    }

    @GetMapping
    List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity getOne(@PathVariable String id) {
        return carService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCar(@PathVariable String id) {
        carService.delete(id);
    }
}
