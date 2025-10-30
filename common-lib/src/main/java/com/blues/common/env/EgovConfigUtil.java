package com.blues.common.env;

import io.github.cdimascio.dotenv.Dotenv;

public class EgovConfigUtil {
    public static void d() {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach((entry) -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
    }
}
