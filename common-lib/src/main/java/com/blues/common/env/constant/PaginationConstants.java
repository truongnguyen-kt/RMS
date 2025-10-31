package com.blues.common.env.constant;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;

@UtilityClass
public class PaginationConstants {
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 50;
    public static final int DEFAULT_PAGE = 0;
    public static final Sort.Direction DEFAULT_DIRECTION = Sort.Direction.DESC;
    public static final String SORT_BY = "";
}
