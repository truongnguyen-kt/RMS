package com.blues.iamservice.config;

import com.blues.common.env.config.inf.ResourceLanguage;
import com.blues.common.env.config.inf.ResourceLanguageImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class I18nConfig {

    @Bean
    public ResourceLanguage resourceLanguage(MessageSource messageSource) {
        return new ResourceLanguageImpl(messageSource);
    }
}