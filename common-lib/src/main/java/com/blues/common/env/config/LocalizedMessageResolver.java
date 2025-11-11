package com.blues.common.env.config;
import com.blues.common.env.config.inf.ResourceLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalizedMessageResolver {
    private static ResourceLanguage staticResourceLanguage;

    private final ResourceLanguage resourceLanguage;

    @jakarta.annotation.PostConstruct
    public void init() {
        staticResourceLanguage = resourceLanguage;
    }

    public static String resolve(String key, Object... args) {
        if (staticResourceLanguage == null) {
            return key; // fallback
        }
        return staticResourceLanguage.get(key, args);
    }
}