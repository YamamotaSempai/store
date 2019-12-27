package kz.aa.store.global.proxy;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NamedParameterJdbcTemplateProxy implements InvocationHandler {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplateProxy(Object obj) {
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) obj;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(namedParameterJdbcTemplate.getClass().getClassLoader(),
                namedParameterJdbcTemplate.getClass().getInterfaces(),
                new NamedParameterJdbcTemplateProxy(namedParameterJdbcTemplate));
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if ("queryForObject".equals(method.getName())) {
            try {
                return method.invoke(namedParameterJdbcTemplate, objects);
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof EmptyResultDataAccessException) {
                    return null;
                } else e.getCause();
            }
        }
        return method.invoke(namedParameterJdbcTemplate, objects);
    }
}