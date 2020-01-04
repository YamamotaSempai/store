package kz.aa.store.items.service;

import kz.aa.store.global.model.base.BaseItem;
import kz.aa.store.global.model.dto.Filter;
import kz.aa.store.items.repository.ItemJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemJdbcRepository itemJdbcRepository;

    @Autowired
    public ItemService(ItemJdbcRepository itemJdbcRepository) {
        this.itemJdbcRepository = itemJdbcRepository;
    }

    public Page<BaseItem> findAllItemsWithFilers(Filter filter, Pageable pageable) {
        Long count = itemJdbcRepository.countItems(filter);
        if (count == null || count == 0)
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        List<BaseItem> content = itemJdbcRepository.findAllItemsWithFilers(filter, pageable);
        return new PageImpl<>(content, pageable, count);
    }
}
