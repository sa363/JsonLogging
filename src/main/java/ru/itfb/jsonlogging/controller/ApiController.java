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
