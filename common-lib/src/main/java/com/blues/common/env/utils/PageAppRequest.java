package com.blues.common.env.utils;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PageAppRequest {
    private String keywords;
    private Boolean active;
    private String sortBy;
    private Sort.Direction direction = Sort.Direction.DESC;
    private Integer pageSize = 10;
    private Integer pageNumber = 0;
}
