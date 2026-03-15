package com.carblog.principalblog.application.dto;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.valueobject.Id;

import java.util.UUID;

public record CategoryOutputDto(
        UUID id, String nameCategory
) {
    public static CategoryOutputDto from(Category category){
        return new CategoryOutputDto(
                category.getCategoryId().value(),
                category.getNameCategory()
        );
    }
}
