package linguosmart.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

public abstract class AbstractSearchController extends AbstractBaseController {

    protected abstract String getDefaultSort();

    protected Map<String, String> defaultSorts = new HashMap<>();

    protected void registerDefaultSort(String key, String defaultSort) {
        defaultSorts.put(key, defaultSort);
    }

    private String useDefaultSort(String key) {
        return defaultSorts.getOrDefault(key, getDefaultSort());
    }

    protected Pageable buildPageable() {
        return buildPageable(null);
    }

    protected Pageable buildPageable(String defaultSortKey) {
        String sortCriteria = Optional.ofNullable(request.getParameter("sortCriteria")).orElse(useDefaultSort(defaultSortKey));
        int pageNumber = Integer.parseInt(Optional.ofNullable(request.getParameter("pageNumber")).orElse("0"));
        int pageSize = Integer.parseInt(Optional.ofNullable(request.getParameter("pageSize")).orElse("0"));

        Sort sort = buildSortCriteria(sortCriteria);

        if (pageSize <= 0) {
            // If the page is unpaged, the sort is not accepted, use buildSortCriteria() instead for unpaged search
            // Temp workaround for unpaged search with sorting
            return PageRequest.of(0, Integer.MAX_VALUE, sort);
        } else {
            return PageRequest.of(pageNumber, pageSize, sort);
        }
    }

    protected Sort buildSortCriteria() {
        String sortCriteria = Optional.ofNullable(request.getParameter("sortCriteria")).orElse(getDefaultSort());
        return buildSortCriteria(sortCriteria);
    }

    private Sort buildSortCriteria(String sortCriteria) {
        List<Sort.Order> orders = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(sortCriteria, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            String[] splitToken = token.split(" ", 2);
            Sort.Direction direction = Sort.Direction.ASC;
            if (splitToken.length > 1 && Sort.Direction.DESC.name().equals(splitToken[1].toUpperCase()))
                    direction = Sort.Direction.DESC;

            orders.add(new Sort.Order(direction, splitToken[0]));
        }
        return Sort.by(orders);
    }
}
