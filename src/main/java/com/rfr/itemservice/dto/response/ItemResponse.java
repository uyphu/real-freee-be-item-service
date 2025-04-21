// ItemResponse.java
package com.rfr.itemservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ItemResponse {
    private UUID id;
    private String title;
    private String description;
    private String category;
    private String condition;
    private String[] photoUrls;
    private String location;
    private Integer pointValue;
    private String status;
    private UUID giverId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}