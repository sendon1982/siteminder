package com.mjiang.email.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static String convertToString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String result = null;

        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.warn("Failed to convert object to json string");
        }

        return result;
    }

}
