package com.blues.iamservice.controller;

import com.blues.common.env.config.inf.ResourceLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i18n-test")
@RequiredArgsConstructor
public class I18nTestController {

    private final ResourceLanguage resourceLanguage;

    @GetMapping
    public String test() {
        return resourceLanguage.get("message.validation.role.duplicate");
    }
}

