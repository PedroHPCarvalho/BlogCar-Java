package com.carblog.principalblog.api.request;

import java.util.Objects;

public record CreateCategoryRequest(String nameCategory) {
    public CreateCategoryRequest{
        Objects.requireNonNull(nameCategory, "Category needs name");
    }
}
