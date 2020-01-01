package kz.aa.store.items.repository;

import kz.aa.store.global.model.base.BaseItem;
import kz.aa.store.global.model.dto.Filter;
import kz.aa.store.global.model.enumeration.ItemType;
import kz.aa.store.global.util.BaseItemConverter;
import kz.aa.store.global.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class ItemJdbcRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final BaseItemConverter baseItemConverter;

    @Autowired
    public ItemJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BaseItemConverter baseItemConverter) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.baseItemConverter = baseItemConverter;
    }

    public List<BaseItem> findAllItemsWithFilers(Filter filter, Pageable pageable) {
        SqlParameterSource parameterSource = new MapSqlParameterSource();
        String query = "SELECT * FROM base_item" +
                QueryBuilder.createQueryString(filter, pageable);
        return namedParameterJdbcTemplate.queryForList(query, parameterSource)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Long countItems(Filter filter) {
        SqlParameterSource parameterSource = new MapSqlParameterSource();
        String query = "SELECT count(id) FROM base_item" +
                QueryBuilder.createQueryString(filter, null);
        return namedParameterJdbcTemplate.queryForObject(query, parameterSource, Long.class);
    }


    private BaseItem map(Map<String, Object> result) {
        ItemType itemType = ItemType.values()[(int) result.get("item_type")];
        switch (itemType) {
            case PANTS:
                return baseItemConverter.convertToPants(result);
            case SHIRT:
                return new BaseItem();
            default:
                throw new IllegalStateException("Unexpected value: " + itemType);
        }
    }
}
