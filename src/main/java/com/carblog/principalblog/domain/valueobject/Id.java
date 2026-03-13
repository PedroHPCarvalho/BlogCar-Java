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

    @Override
    public String toString() {
        return value.toString();
    }
}
