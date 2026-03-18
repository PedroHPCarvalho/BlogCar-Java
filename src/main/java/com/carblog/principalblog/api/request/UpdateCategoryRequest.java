package com.carblog.principalblog.api.request;

import java.util.Objects;
import java.util.UUID;

public record UpdateCategoryRequest(UUID id, String nameCategory){
    public UpdateCategoryRequest{
        Objects.requireNonNull(id, "Id is not null");
        Objects.requireNonNull(nameCategory, "Category needs name");
    }
}
