package ru.itfb.jsonlogging.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class JsonDataDto implements Serializable {
//    @JsonIgnore
//    private final Long id;
    private final UUID uuid;
    private final String jsonData;
}
