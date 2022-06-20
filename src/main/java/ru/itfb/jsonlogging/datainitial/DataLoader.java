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

package ru.itfb.jsonlogging.datainitial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.itfb.jsonlogging.model.dto.JsonDataDto;
import ru.itfb.jsonlogging.service.impl.JsonDataServiceImpl;

import java.util.UUID;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final JsonDataServiceImpl service;

    public DataLoader(JsonDataServiceImpl service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) {
        UUID uuid = UUID.randomUUID();
        JsonDataDto data = new JsonDataDto(uuid, "{\"menu\": {\"id\":\"file\"}\"}");
        log.info("Add Data {}", data);
        service.addJson(data);
    }
}
