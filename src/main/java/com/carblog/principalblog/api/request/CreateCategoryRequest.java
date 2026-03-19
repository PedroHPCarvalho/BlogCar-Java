package com.carblog.principalblog.api.request;

import com.carblog.principalblog.application.dto.CategoryInputDto;

import java.util.Objects;

public record CreateCategoryRequest(String nameCategory) {
    public CreateCategoryRequest{
        Objects.requireNonNull(nameCategory, "Category needs name");
    }

    public static CategoryInputDto toDto(CreateCategoryRequest createCategoryRequest){
        return new CategoryInputDto(createCategoryRequest.nameCategory());
    }
}
