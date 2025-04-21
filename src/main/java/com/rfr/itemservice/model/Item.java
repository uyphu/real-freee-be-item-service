// Item.java
package com.rfr.itemservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "items")
//@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String category;

    private String condition;

    @Column(name = "photo_urls", columnDefinition = "TEXT[]")
    private String[] photoUrls;

    private String location;

    @Column(name = "point_value")
    private Integer pointValue;

    private String status; // AVAILABLE, RESERVED, COLLECTED

    @Column(name = "giver_id")
    private UUID giverId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
} 