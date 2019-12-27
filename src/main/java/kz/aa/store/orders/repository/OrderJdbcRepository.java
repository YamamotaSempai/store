package kz.aa.store.orders.repository;

import kz.aa.store.global.proxy.NamedParameterJdbcTemplateProxy;
import kz.aa.store.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderJdbcRepository {
    private final NamedParameterJdbcOperations jdbcTemplate;

    @Autowired
    public OrderJdbcRepository(NamedParameterJdbcTemplateProxy jdbcTemplate) {
        this.jdbcTemplate = (NamedParameterJdbcOperations) jdbcTemplate.newInstance();
    }


    public List<Order> getAllOrdersByUser(String username, Pageable pageable) {
        String query = "SELECT * FROM orders"; // TODO: 24.12.19 rewrite query
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username", username)
                .addValue("pageable", pageable); // TODO: 24.12.19 change parameters
        return jdbcTemplate.queryForList(query, parameterSource)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Long getCountOrdersByUser(String username) {
        String query = "SELECT COUNT(*) FROM orders"; // TODO: 24.12.19 rewrite query
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username", username);
        return jdbcTemplate.queryForObject(query, parameterSource, Long.class);
    }

    public Long preSave(String username) {
        String query =
                "INSERT INTO orders(username)" +
                        " VALUES(:username) returning id; ";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username", username);
        return jdbcTemplate.queryForObject(query, parameterSource, Long.class);
    }

    private Order map(Map<String, Object> resultMap) {
        Order order = new Order(); // TODO: 24.12.19 change to dto
        return order;
    }
}
