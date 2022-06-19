package ru.itfb.jsonlogging.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itfb.jsonlogging.model.JsonData;

import java.util.Optional;
import java.util.UUID;

public interface JsonDataRepository extends CrudRepository<JsonData, Long> {
    public Optional<JsonData> findByUuid(UUID uuid);
    public boolean existsByUuid(UUID uuid);
}