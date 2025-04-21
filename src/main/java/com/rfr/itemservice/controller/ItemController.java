// ItemController.java
package com.rfr.itemservice.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rfr.itemservice.dto.request.CreateItemRequest;
import com.rfr.itemservice.dto.response.ItemResponse;
import com.rfr.itemservice.service.ItemService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody CreateItemRequest request) {
        return ResponseEntity.ok(itemService.createItem(request));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable UUID id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable UUID id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/collect")
    public ResponseEntity<ItemResponse> markCollected(@PathVariable UUID id) {
        return ResponseEntity.ok(itemService.markItemCollected(id));
    }
}