package com.example.strategy.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.strategy.dto.IPLocationDTO;

@Service
@ConditionalOnProperty(name = "ip.service", havingValue = "ip2location")
public class IP2LocationSearchService implements SearchService{
    @Override
    public IPLocationDTO search(String ip) {
        RandomStringUtils randomStringUtils = RandomStringUtils.secure();
        return new IPLocationDTO(randomStringUtils.nextAlphabetic(2),
                                 randomStringUtils.nextAlphanumeric(3),
                                 getName());
    }

    @Override
    public String getName() {
        return "IP2Location";
    }
}
