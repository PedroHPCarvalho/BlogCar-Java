package com.carblog.principalblog.api.response;

import com.carblog.principalblog.application.dto.CategoryOutputDto;

import java.util.UUID;

public record CategoryResponse(UUID id, String nameCategory) {

    public static CategoryResponse fromCategoryOutputDto(CategoryOutputDto categoryOutputDto){
        return new CategoryResponse(categoryOutputDto.id(),categoryOutputDto.nameCategory());
    }

    public static CategoryResponse fromDto(CategoryOutputDto categoryOutputDto){
        return new CategoryResponse(categoryOutputDto.id(),categoryOutputDto.nameCategory());
    }
}
