package com.practice.gadsaaleaderboard.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperFactory {

    private ObjectMapperFactory() { }

    public static ObjectMapper objectMapper() {
        return new ObjectMapper()
                .setDateFormat(new SafeDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").raw())
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
