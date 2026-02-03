package com.example.strategy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.strategy.dto.IPLocationDTO;
import com.example.strategy.service.SearchService;

@RestController
public class IPLocationController {
    private final SearchService service;

    @Autowired
    public IPLocationController(SearchService service) {
        this.service = service;
    }

    @GetMapping(path = "/api/ip/{ip}", produces = "application/json")
    public IPLocationDTO getLocation(String ip) {
        return service.search(ip);
    }
}
