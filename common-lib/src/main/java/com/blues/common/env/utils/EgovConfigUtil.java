package com.blues.common.env.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;

public class EgovConfigUtil {
    public static void d() {
        System.out.println(">>> Loading .env from: " + new File(".").getAbsolutePath());
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach((entry) -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
    }
}
