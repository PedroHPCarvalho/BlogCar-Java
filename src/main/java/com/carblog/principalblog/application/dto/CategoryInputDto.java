package com.carblog.principalblog.application.dto;

import java.util.Objects;

public record CategoryInputDto(String nameCategory) {

    public CategoryInputDto {
        Objects.requireNonNull(nameCategory, "Name of Category is not null");
    }
}
