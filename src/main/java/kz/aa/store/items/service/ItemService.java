package kz.aa.store.items.service;

import kz.aa.store.items.repository.ItemJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemJdbcRepository itemJdbcRepository;

    @Autowired
    public ItemService(ItemJdbcRepository itemJdbcRepository) {
        this.itemJdbcRepository = itemJdbcRepository;
    }
}
