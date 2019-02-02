package com.lubaszak.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;



public enum Sex {

    MAN,
    WOMAN;

    private static Map<String, Sex> namesMap = new HashMap<>();

    static {
        namesMap.put("man", MAN);
        namesMap.put("woman", WOMAN);
    }
    @JsonCreator
    public static Sex forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }

    @JsonValue
    public String toValue() {
        for(Map.Entry<String, Sex> entry: namesMap.entrySet()) {
            return entry.getKey();
        }
        return null;
    }



}
