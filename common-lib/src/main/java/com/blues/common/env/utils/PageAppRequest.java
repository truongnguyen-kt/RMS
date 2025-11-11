package com.blues.common.env.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@RequiredArgsConstructor
public class PageAppRequest {
    private String keywords;
    private Boolean active;
    private String sortBy;
    private Sort.Direction direction = (sortBy == null) ? null : Sort.Direction.DESC;
    private Integer pageSize = 10;
    private Integer pageNumber = 0;
}
