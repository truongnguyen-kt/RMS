package com.blues.iamservice.config;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("GUEST");
    }
}
