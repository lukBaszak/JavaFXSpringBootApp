package com.lubaszak.utilities;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;


import java.util.HashMap;
import java.util.Map;

public enum Activity {

    VERY_LOW,
    LOW,
    MEDIUM,
    HIGH;

    private static Map<String, Activity> namesMap = new HashMap<>();

    static {
        namesMap.put("veryLow", VERY_LOW);
        namesMap.put("low", LOW);
        namesMap.put("medium", MEDIUM);
        namesMap.put("high", HIGH);

    }

    @JsonCreator
    public static Activity forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }

    @JsonValue
    public String toValue() {
        for(Map.Entry<String, Activity> entry: namesMap.entrySet()) {
            return entry.getKey();
        }
        return null;
    }


}
