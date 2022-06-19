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

package ru.itfb.jsonlogging.controller;

import org.springframework.web.bind.annotation.*;
import ru.itfb.jsonlogging.model.JsonData;
import ru.itfb.jsonlogging.model.dto.JsonDataDto;
import ru.itfb.jsonlogging.service.impl.JsonDataServiceImpl;

import java.util.UUID;

@RestController
public class ApiController {
    private final JsonDataServiceImpl service;

    public ApiController(JsonDataServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/")
    public JsonData addLog(@RequestBody JsonDataDto jsonDataDto) {
        return service.addJson(jsonDataDto);
    }

    @GetMapping("/{uuid}")
    public JsonData  getLog(@PathVariable UUID uuid) {
        return service.getJson(uuid);
    }


}
