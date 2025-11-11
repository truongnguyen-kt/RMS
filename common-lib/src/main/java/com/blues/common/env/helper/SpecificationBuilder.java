package com.blues.common.env.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class SpecificationBuilder<T> {
    private boolean useOr = false;
    private Specification<T> spec;

    public SpecificationBuilder() {

    }

    public SpecificationBuilder<T> concat(Specification<T> specification) {
        applyCondition(specification);
        return this;
    }

    public SpecificationBuilder<T> or() {
        this.useOr = true;
        return this;
    }

    public SpecificationBuilder<T> and() {
        this.useOr = false;
        return this;
    }

    public Specification<T> build() {
        return spec;
    }

    private void applyCondition(Specification<T> specification) {
        if (spec == null) {
            this.spec = specification;
        } else if (this.useOr) {
            this.spec = this.spec.or(specification);
        } else {
            this.spec = this.spec.and(specification);
        }
        this.useOr = false;
    }
}
