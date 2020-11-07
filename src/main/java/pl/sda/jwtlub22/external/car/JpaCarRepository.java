package pl.sda.jwtlub22.external.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCarRepository extends JpaRepository<CarEntity, Long> {
}
