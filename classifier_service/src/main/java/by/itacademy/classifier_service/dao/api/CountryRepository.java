package by.itacademy.classifier_service.dao.api;


import by.itacademy.classifier_service.dao.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country,UUID> {
    boolean existsByUuid (UUID uuid);
}
