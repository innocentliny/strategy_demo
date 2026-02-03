package com.example.strategy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 回傳給前端的資料
 * @param country 國家
 * @param province 行政區
 * @param searchServiceName 使用哪個 IP 地理資訊查詢服務
 */
public record IPLocationDTO(String country, String province, @JsonProperty("service") String searchServiceName) {
}
