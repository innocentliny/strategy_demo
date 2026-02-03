package com.example.strategy.service;

import com.example.strategy.dto.IPLocationDTO;

public interface SearchService {
    IPLocationDTO search(String ip);
    String getName();
}
