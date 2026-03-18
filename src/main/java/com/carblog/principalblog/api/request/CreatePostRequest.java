package com.carblog.principalblog.api.request;

import java.util.Objects;

public record CreatePostRequest(
        String categoryId,
        String titlePost,
        String subTitlePost,
        String bodyPost
) {
    public CreatePostRequest {
        Objects.requireNonNull(categoryId, "Category is not null");
        Objects.requireNonNull(titlePost, "title is not null");
        Objects.requireNonNull(subTitlePost, "subtitle is not null");
        Objects.requireNonNull(bodyPost, "bodyPost is not null");
    }
}
