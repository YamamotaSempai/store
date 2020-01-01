package kz.aa.store.global.util;

import kz.aa.store.global.model.dto.Filter;
import org.springframework.data.domain.Pageable;

public class QueryBuilder {

    public static String createQueryString(Filter filter, Pageable pageable) {
        StringBuilder stringBuilder = new StringBuilder();
        if (pageable != null) {
            stringBuilder.append(" OFFSET ").append(pageable.getOffset());
            stringBuilder.append(" LIMIT ").append(pageable.getPageSize());
        }

        return stringBuilder.toString();
    }
}
