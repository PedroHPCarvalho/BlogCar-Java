package com.carblog.principalblog.infrastructure.persistence.mapper;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.infrastructure.persistence.entity.CategoryJpa;

public class CategoryMapper {
    public static CategoryJpa toJpa(Category category){
        return new CategoryJpa(
                category.getCategoryId().value(),
                category.getNameCategory()
        );
    }

    public static Category toEntity(CategoryJpa categoryJpa){
        return Category.restoreCategory(categoryJpa.getId(),categoryJpa.getNameCategory());
    }
}
