// CreateItemRequest.java
package com.rfr.itemservice.dto.request;

import lombok.Data;

@Data
public class CreateItemRequest {
    private String title;
    private String description;
    private String category;
    private String condition;
    private String[] photoUrls;
    private String location;
    private Integer pointValue;
    private String giverId; // to be converted to UUID later
}

