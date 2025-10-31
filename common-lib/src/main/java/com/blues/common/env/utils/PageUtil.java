package com.blues.common.env.utils;

import com.blues.common.env.constant.PaginationConstants;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class PageUtil {

    public static Pageable getPageable(PageAppRequest page) {
        if (Objects.isNull(page)) {
            page = new PageAppRequest();
        }
        int pageNumber = Math.max(page.getPageNumber(), PaginationConstants.DEFAULT_PAGE);
        int pageSize = Math.min(page.getPageSize(), PaginationConstants.MAX_PAGE_SIZE);
        return org.springframework.data.domain.PageRequest.of(
                pageNumber,
                pageSize,
                Objects.nonNull(page.getDirection()) ? page.getDirection() : PaginationConstants.DEFAULT_DIRECTION,
                Objects.nonNull(page.getSortBy()) ? page.getSortBy() : PaginationConstants.SORT_BY);
    }

    public static Sort getSort(PageAppRequest page) {
        if (Objects.isNull(page)) {
            return Sort.unsorted();
        }

        Sort.Direction direction =
                Objects.nonNull(page.getDirection()) ? page.getDirection() : PaginationConstants.DEFAULT_DIRECTION;
        String sortBy = Objects.nonNull(page.getSortBy()) ? page.getSortBy() : PaginationConstants.SORT_BY;
        return Sort.by(direction, sortBy);
    }

    /**
     * Performs in-memory pagination on a given list.
     *
     * <p>
     * This method simulates Spring Data JPA's pagination behavior by slicing a
     * sublist from the full list based on the provided page number and page size.
     *
     * @param lstData
     *            The full list of data to paginate.
     * @param page
     *            The current page number (0-based).
     * @param size
     *            The number of items per page.
     * @return A Page object containing the sublist and pagination metadata.
     */
    public <T> Page<T> paginate(List<T> lstData, int page, int size) {
        int fromIndex = page * size;
        if (fromIndex >= lstData.size()) {
            return new PageImpl<>(
                    Collections.emptyList(),
                    org.springframework.data.domain.PageRequest.of(page, size),
                    lstData.size());
        }
        int toIndex = Math.min(fromIndex + size, lstData.size());
        List<T> subList = lstData.subList(fromIndex, toIndex);
        return new PageImpl<>(subList, org.springframework.data.domain.PageRequest.of(page, size), lstData.size());
    }
}
