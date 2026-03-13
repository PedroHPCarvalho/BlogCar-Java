package com.carblog.principalblog.application.dto;

import java.util.Objects;

public record PostInputDto(
        String categoryId,
        String  titlePost,
        String subTitlePost,
        String bodyPost
) {
        public PostInputDto{
            Objects.requireNonNull(categoryId, "Category is not null");
            Objects.requireNonNull(titlePost, "title is not null");
            Objects.requireNonNull(subTitlePost, "subtitle is not null");
            Objects.requireNonNull(bodyPost, "bodyPost is not null");
        }
}
