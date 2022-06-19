/*
 *
 *  * Copyright 2002-2022 the Sergey Anisimov <s.anisimov@gmail.com>
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

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
