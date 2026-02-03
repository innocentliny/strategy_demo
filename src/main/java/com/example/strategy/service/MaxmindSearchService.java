package com.example.strategy.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.strategy.dto.IPLocationDTO;

@Service
@ConditionalOnProperty(name = "ip.service", havingValue = "maxmind")
public class MaxmindSearchService implements SearchService{
    @Override
    public IPLocationDTO search(String ip) {
        RandomStringUtils randomStringUtils = RandomStringUtils.secure();
        return new IPLocationDTO(randomStringUtils.nextAlphabetic(2),
                                 randomStringUtils.nextAlphanumeric(3),
                                 getName());
    }

    @Override
    public String getName() {
        return "Maxmind";
    }
}
