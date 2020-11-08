package pl.sda.jwtlub22.external.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "cars")
public class CarDocument {

    @Id
    private String id;

    private String manufacturer;
    private String model;
}
