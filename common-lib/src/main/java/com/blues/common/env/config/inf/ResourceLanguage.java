package com.blues.common.env.config.inf;

public interface ResourceLanguage {

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    String get(final String key);

    /**
     * Get string.
     *
     * @param key     the key
     * @param objects the objects
     * @return the string
     */
    String get(final String key, final Object... objects);
}
