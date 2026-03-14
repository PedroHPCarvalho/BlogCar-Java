package com.carblog.principalblog.application.dto;

import java.util.Objects;

public record PostUpdateDto(
        String id,
        String categoryId,
        String titlePost,
        String subTitlePost,
        String bodyPost
) {
        public PostUpdateDto{
            Objects.requireNonNull(id, "Id is not null");
            Objects.requireNonNull(categoryId, "Category is not null");
            Objects.requireNonNull(titlePost, "title is not null");
            Objects.requireNonNull(subTitlePost, "subtitle is not null");
            Objects.requireNonNull(bodyPost, "bodyPost is not null");
        }
}
