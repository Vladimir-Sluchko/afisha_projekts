package by.itacademy.classifier_service.dao.api;


import by.itacademy.classifier_service.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category,UUID> {
    boolean existsByUuid (UUID uuid);
}
