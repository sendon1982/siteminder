package com.mjiang.email.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public static String convertToString(Object object) {
        String result = null;

        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.warn("Failed to convert object to json string");
        }

        return result;
    }

    /**
     * Convert a json string with TypeReference like <code>new TypeReference<>(){}</code>
     *
     * @param json
     *
     * @param type
     *
     * @param <T>
     *
     * @return
     */
    public static <T> T convertToObject(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }

        T result = null;

        try {
            result = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.warn("Failed to convert object to json string {}", json);
        }

        return result;
    }
}
