// ItemServiceImpl.java
package com.rfr.itemservice.service.impl;

import com.rfr.itemservice.dto.request.CreateItemRequest;
import com.rfr.itemservice.dto.response.ItemResponse;
import com.rfr.itemservice.model.Item;
import com.rfr.itemservice.repository.ItemRepository;
import com.rfr.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public ItemResponse createItem(CreateItemRequest request) {
        Item item = Item.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .condition(request.getCondition())
                .photoUrls(request.getPhotoUrls())
                .location(request.getLocation())
                .pointValue(request.getPointValue())
                .status("AVAILABLE")
                .giverId(UUID.fromString(request.getGiverId()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return toResponse(itemRepository.save(item));
    }

    @Override
    public List<ItemResponse> getAllItems() {
        return itemRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponse getItemById(UUID id) {
        return itemRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemResponse markItemCollected(UUID id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setStatus("COLLECTED");
        item.setUpdatedAt(LocalDateTime.now());
        return toResponse(itemRepository.save(item));
    }

    private ItemResponse toResponse(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .category(item.getCategory())
                .condition(item.getCondition())
                .photoUrls(item.getPhotoUrls())
                .location(item.getLocation())
                .pointValue(item.getPointValue())
                .status(item.getStatus())
                .giverId(item.getGiverId())
                .createdAt(item.getCreatedAt())
                .updatedAt(item.getUpdatedAt())
                .build();
    }
}
