package kz.aa.store.items.controller;

import kz.aa.store.global.model.dto.Filter;
import kz.aa.store.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("items")
public class ItemController {
    // TODO: 22.12.19 end-points for getting item

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<?> findAllItems(@NotNull Pageable pageable) {
        return ResponseEntity.ok(itemService.findAllItemsWithFilers(null, pageable));
    }
}
