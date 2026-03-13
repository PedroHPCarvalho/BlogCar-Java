package com.carblog.principalblog.domain.entity;
import com.carblog.principalblog.domain.valueobject.Id;
import java.util.Objects;


public class Category {
    private Id categoryId;
    private String nameCategory;

    // Construtor Privado
    private Category(String nameCategory){
        Objects.requireNonNull(nameCategory, "Name is Not Null");
        this.categoryId = Id.newId();
        this.nameCategory = nameCategory;
    }

    //Factory Method
    public static Category newCategory(String nameCategory){
        return new Category(nameCategory);
    }

    public Id getCategoryId() {
        return categoryId;
    }
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
