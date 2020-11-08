package pl.sda.jwtlub22.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {
    private String id;
    private String manufacturer;
    private String model;
}
