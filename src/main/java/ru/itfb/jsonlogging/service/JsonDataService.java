package ru.itfb.jsonlogging.service;

import ru.itfb.jsonlogging.model.JsonData;
import ru.itfb.jsonlogging.model.dto.JsonDataDto;

import java.util.UUID;

public interface JsonDataService {
    JsonData addJson (JsonDataDto jsonDataDto);
    JsonData getJson (UUID uuid);
}
