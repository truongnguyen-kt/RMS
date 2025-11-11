package com.blues.common.env.config.inf;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ResourceLanguageImpl implements ResourceLanguage {

    private final MessageSource messageSource;

    @Override
    public String get(String key) {
        try {
            return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        } catch (Exception exception) {
            log.error("Exception Occurred with at ResourceLanguageIml.get with key: {}", key, exception);
            return key;
        }
    }

    @Override
    public String get(String key, Object... objects) {
        try {
            return messageSource.getMessage(key, objects, LocaleContextHolder.getLocale());
        } catch (Exception exception) {
            log.error("Exception Occurred with at ResourceLanguageIml.get with key: {}", key, exception);
            return key;
        }
    }
}