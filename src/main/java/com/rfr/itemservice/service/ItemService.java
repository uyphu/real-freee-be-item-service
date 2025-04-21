// ItemService.java
package com.rfr.itemservice.service;

import com.rfr.itemservice.dto.request.CreateItemRequest;
import com.rfr.itemservice.dto.response.ItemResponse;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemResponse createItem(CreateItemRequest request);
    List<ItemResponse> getAllItems();
    ItemResponse getItemById(UUID id);
    void deleteItem(UUID id);
    ItemResponse markItemCollected(UUID id);
}
