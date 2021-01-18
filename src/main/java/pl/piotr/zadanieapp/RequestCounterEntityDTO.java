package pl.piotr.zadanieapp;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCounterEntityDTO extends JpaRepository<RequestCounterEntity, String> {
}
