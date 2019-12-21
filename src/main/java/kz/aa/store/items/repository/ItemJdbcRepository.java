package kz.aa.store.items.repository;

import kz.aa.store.global.model.base.BaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ItemJdbcRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ItemJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Page<BaseItem> findAllItems(Pageable pageable) {
        String query = "";
        SqlParameterSource parameterSource = new MapSqlParameterSource();
        List<Object> content = namedParameterJdbcTemplate.queryForList(query, parameterSource)
                .stream()
                .map()
                .collect(Collectors.toList());

        return new PageImpl<>(content, pageable, );
    }

    // TODO: 22.12.19 map and count add to util
}
