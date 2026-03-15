package com.carblog.principalblog.domain.entity;
import com.carblog.principalblog.domain.valueobject.Id;
import java.util.Objects;
import java.util.UUID;


public class Category{
    private Id categoryId;
    private String nameCategory;

    // Construtor Privado
    private Category(String nameCategory){
        Objects.requireNonNull(nameCategory, "Name is Not Null");
        this.categoryId = Id.newId();
        this.nameCategory = nameCategory;
    }

    private static Category restore(UUID id, String nameCategoryq){
        Objects.requireNonNull(id, "Id is Not Null");
        Objects.requireNonNull(nameCategoryq, "Name is Not Null");
        Category category = new Category(nameCategoryq);
        category.categoryId = Id.restoreId(id);
        return category;
    }

    //Factory Method
    public static Category newCategory(String nameCategory){
        return new Category(nameCategory);
    }

    public static Category restoreCategory(UUID id, String nameCategory){
        return restore(id, nameCategory);
    }

    // getter
    public Id getCategoryId() {
        return categoryId;
    }
    public String getNameCategory() {
        return nameCategory;
    }

    // setter
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
