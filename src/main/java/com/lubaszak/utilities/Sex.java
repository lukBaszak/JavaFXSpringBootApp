package com.lubaszak.utilities;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;


@JsonAdapter(Sex.Serializer.class)
public enum Sex {

    MAN(0),

    WOMAN(1);


    int sexCode;

    Sex(int sexCode) {
        this.sexCode = sexCode;
    }


    static Sex getSexByCode(int sexCode) {
        for (Sex sex : values())
            if (sex.sexCode == sexCode) return sex;
        return null;
    }

    static class Serializer implements JsonSerializer<Sex>, JsonDeserializer<Sex> {
        @Override
        public JsonElement serialize(Sex src, Type typeOfSrc, JsonSerializationContext context) {

            return context.serialize(src.sexCode);
        }

        @Override
        public Sex deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            try {
                return getSexByCode(json.getAsNumber().intValue());
            } catch (JsonParseException e) {
                return null;
            }
        }
    }

}
