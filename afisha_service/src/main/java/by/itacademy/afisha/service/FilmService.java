package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IFilmDao;
import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import by.itacademy.afisha.service.componets.UserHolder;
import by.itacademy.afisha.service.dto.ConcertReadDto;
import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import by.itacademy.afisha.service.dto.PageDto;
import by.itacademy.afisha.service.utils.ClassifierClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.OptimisticLockException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class FilmService implements IFilmService {
    private final IFilmDao repository;
    private final ModelMapper mapper;
    private final ClassifierClient checkUuid;
    private final UserHolder holder;

    @Autowired
    public FilmService(IFilmDao eventFilmDao, RestTemplate restTemplate, ModelMapper mapper, ClassifierClient checkUuid, UserHolder holder) {
        this.repository = eventFilmDao;
        this.checkUuid = checkUuid;
        this.mapper = mapper;
        this.holder = holder;
    }

    @Override
    @Transactional
    public FilmCreateDto create(FilmCreateDto eventFilm) {
        if(checkUuid.isCheckUuidCountry(eventFilm.getCountry())){
            Film entity = mapper.map(eventFilm, Film.class);
            entity.setUuid(UUID.randomUUID());
            entity.setDtCreate(LocalDateTime.now());
            entity.setDtUpdate(LocalDateTime.now());
            entity.setAuthor(holder.getUser().getUsername());
            repository.save(entity);
        }else {
            throw new OptimisticLockException("There is no such county in the directory");
        }

        return eventFilm;
    }

    @Override
    public PageDto<FilmReadDto> getAll(int page, int size ) {
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Film> pageEntity;

        if(holder.getUser().getUsername() == null){
            pageEntity = repository.findByTypeAndStatus(Type.FILMS, Status.PUBLISHED,pageRequest);
        } else if (!holder.getUser().getAuthorities()
                .stream()
                .filter(role -> "ADMIN".equals(role.getAuthority()))
                .findAny().isEmpty()){
            pageEntity = repository.findByType(Type.FILMS,pageRequest);
        } else pageEntity = repository
                .findByTypeAndStatusIsOrAuthorIs(Type.FILMS, Status.PUBLISHED, holder.getUser().getUsername(), pageRequest);

        List<FilmReadDto> listDto = pageEntity
                .getContent().stream().map(element -> mapper.map(element, FilmReadDto.class))
                .collect(Collectors.toList());

        Page<FilmReadDto> pageConcert = new PageImpl<>(listDto, pageRequest, pageEntity.getTotalElements());
        return mapper.map(pageConcert,PageDto.class);
    }

    @Override
    @Transactional
    public FilmCreateDto update(FilmCreateDto eventFilm, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());

        Film film = repository.findByUuidAndAuthor(uuid,holder.getUser().getUsername()).orElseThrow(()-> {
            throw new IllegalArgumentException("You cannot edit this post");
        });

        if (!checkUuid.isCheckUuidCountry(eventFilm.getCountry())){
            throw new OptimisticLockException("There is no such country in the directory");
        }

        if (film.getDtUpdate().equals(dateUpdate)) {
            film.setTitle(eventFilm.getTitle());
            film.setDescription(eventFilm.getDescription());
            film.setDtEvent(eventFilm.getDtEvent());
            film.setDtEndOfSale(eventFilm.getDtEndOfSale());
            film.setType(eventFilm.getType());
            film.setStatus(eventFilm.getStatus());
            film.setCountry(eventFilm.getCountry());
            film.setReleaseYear(eventFilm.getReleaseYear());
            film.setReleaseDate(eventFilm.getReleaseDate());
            film.setDuration(eventFilm.getDuration());
            film.setDtUpdate(LocalDateTime.now());
            repository.save(film);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
        return eventFilm;
    }


    @Override
    public FilmReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
         Film film = repository.findById(uuid).
                 orElseThrow(()-> {
                     throw new IllegalArgumentException("No content");
                 });
        if(!film.getAuthor().equals(holder.getUser().getUsername()) && film.getStatus() == Status.DRAFT){
            throw new OptimisticLockException("You can't view the event, it hasn't been published yet");
        }
        return mapper.map(film,FilmReadDto.class);
    }

}
