package kz.aa.store.items.repository;

import kz.aa.store.global.model.base.BaseItem;
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

    @Autowired
    public ItemJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<BaseItem> findAllItems(Pageable pageable) {
        String query = "";
        SqlParameterSource parameterSource = new MapSqlParameterSource();

        return namedParameterJdbcTemplate.queryForList(query, parameterSource)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    // TODO: 22.12.19 map and count add to util
    private BaseItem map(Map<String, Object> result) {
        return new BaseItem();
    }
}
