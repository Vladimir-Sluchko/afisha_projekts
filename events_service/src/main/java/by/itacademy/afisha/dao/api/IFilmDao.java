package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IFilmDao extends JpaRepository<Film, UUID> {
    Page<Film> findByTypeAndStatus(Type type, Status status, Pageable pageable);

    Page<Film> findByType(Type type, Pageable pageable);

    Page<Film> findByTypeAndStatusIsOrAuthorIs(Type type,Status status,String author,Pageable pageable);

    Optional<Film> findByUuidAndAuthor(UUID uuid,String author);
}
