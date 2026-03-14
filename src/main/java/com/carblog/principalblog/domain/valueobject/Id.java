package com.carblog.principalblog.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public record Id(UUID value) {

    public Id{
        Objects.requireNonNull(value, "Id is not Null");
    }

    public static Id newId(){
        return new Id(UUID.randomUUID());
    }

    public static Id fromString(String string){
        try {
            return new Id(UUID.fromString(string));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
