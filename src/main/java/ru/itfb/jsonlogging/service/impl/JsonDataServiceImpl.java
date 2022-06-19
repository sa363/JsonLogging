package ru.itfb.jsonlogging.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.itfb.jsonlogging.exception.JsonDataException;
import ru.itfb.jsonlogging.model.JsonData;
import ru.itfb.jsonlogging.model.dto.JsonDataDto;
import ru.itfb.jsonlogging.repository.JsonDataRepository;
import ru.itfb.jsonlogging.service.JsonDataService;

import javax.transaction.Transactional;
import java.util.UUID;


@Service
public class JsonDataServiceImpl implements JsonDataService {

    private final JsonDataRepository repository;
    private ModelMapper modelMapper;

    public JsonDataServiceImpl(JsonDataRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public JsonData addJson(JsonDataDto jsonDataDto) {
        if (!repository.existsByUuid(jsonDataDto.getUuid())) {
            repository.save(convertToEntity(jsonDataDto));
        }
        return repository.findByUuid(jsonDataDto.getUuid()).orElseThrow(() ->
               new JsonDataException(String.format("No data with uuid %s is available", jsonDataDto.getUuid())));

    }

    @Override
    public JsonData getJson(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() ->
                new JsonDataException(String.format("No data with uuid %s is available", uuid))
        );
    }


    private JsonDataDto convertToDTO(JsonData jsonData) {
        JsonDataDto jsonDataDto = modelMapper.map(jsonData, JsonDataDto.class);
        return jsonDataDto;
    }

    private JsonData convertToEntity(JsonDataDto jsonDataDto) {
        JsonData jsonData = modelMapper.map(jsonDataDto, JsonData.class);
        return jsonData;
    }
}
