package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IConcertDao;
import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import by.itacademy.afisha.service.api.IConcertService;
import by.itacademy.afisha.service.componets.UserHolder;
import by.itacademy.afisha.service.dto.ConcertCreateDto;
import by.itacademy.afisha.service.dto.ConcertReadDto;
import by.itacademy.afisha.service.dto.PageDto;
import by.itacademy.afisha.service.utils.ClassifierClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ConcertService implements IConcertService {
    private final IConcertDao repository;
    private final ClassifierClient checkUuid;
    private final ModelMapper mapper;
    private final UserHolder holder;

    @Autowired
    public ConcertService(IConcertDao repository, ClassifierClient checkUuid,
                          ModelMapper mapper, UserHolder holder) {
        this.repository = repository;
        this.checkUuid = checkUuid;
        this.mapper = mapper;
        this.holder = holder;
    }

    @Override
    @Transactional
    public ConcertCreateDto create(ConcertCreateDto eventConcert) {
        if (checkUuid.isCheckUuidCategory(eventConcert.getCategory())){
            Concert entity = mapper.map(eventConcert,Concert.class);
            entity.setUuid(UUID.randomUUID());
            entity.setDtCreate(LocalDateTime.now());
            entity.setDtUpdate(LocalDateTime.now());
            entity.setAuthor(holder.getUser().getUsername());
            repository.save(entity);
        }else {
            throw new OptimisticLockException("There is no such category in the directory");
        }
        return eventConcert;
    }

    @Override
    public ConcertReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
        Concert concert = repository.findById(uuid).
                orElseThrow(()-> {
                    throw new IllegalArgumentException("No content");
                });
        if(!concert.getAuthor().equals(holder.getUser().getUsername()) && concert.getStatus() == Status.DRAFT){
            throw new OptimisticLockException("You can't view the event, it hasn't been published yet");
        }
        return mapper.map(concert,ConcertReadDto.class);
    }

    @Override
    public PageDto<ConcertReadDto> getAll(int page, int size) {
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Concert> pageEntity;

        if(holder.getUser().getUsername() == null){
            pageEntity = repository.findByTypeAndStatus(Type.CONCERTS, Status.PUBLISHED,pageRequest);
        } else if (!holder.getUser().getAuthorities()
                .stream()
                .filter(role -> "ADMIN".equals(role.getAuthority()))
                .findAny().isEmpty()){
            pageEntity = repository.findByType(Type.CONCERTS,pageRequest);
        } else pageEntity = repository
                .findByTypeAndStatusIsOrAuthorIs(Type.CONCERTS, Status.PUBLISHED, holder.getUser().getUsername(), pageRequest);

        List<ConcertReadDto> listDto = pageEntity
                .getContent().stream().map(element -> mapper.map(element, ConcertReadDto.class))
                .collect(Collectors.toList());

        Page<ConcertReadDto> pageConcert = new PageImpl<>(listDto, pageRequest, pageEntity.getTotalElements());
        return mapper.map(pageConcert,PageDto.class);
    }

    @Override
    @Transactional
    public ConcertCreateDto update(ConcertCreateDto eventConcert, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());

        Concert concert = repository.findByUuidAndAuthor(uuid,holder.getUser().getUsername()).orElseThrow(()-> {
            throw new IllegalArgumentException("You cannot edit this post");
        });

        if (!checkUuid.isCheckUuidCategory(eventConcert.getCategory())){
            throw new OptimisticLockException("There is no such category in the directory");
        }

        if (concert.getDtUpdate().equals(dateUpdate)) {
            concert.setTitle(eventConcert.getTitle());
            concert.setDescription(eventConcert.getDescription());
            concert.setDtEvent(eventConcert.getDtEvent());
            concert.setDtEndOfSale(eventConcert.getDtEndOfSale());
            concert.setType(eventConcert.getType());
            concert.setStatus(eventConcert.getStatus());
            concert.setDtUpdate(LocalDateTime.now());
            repository.save(concert);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
        return eventConcert;
    }
}
