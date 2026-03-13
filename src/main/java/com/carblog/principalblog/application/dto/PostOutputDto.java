package com.carblog.principalblog.application.dto;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.entity.Post;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostOutputDto (
    UUID id,
    CategoryOutputDto category,
    String titlePost,
    String subTitlePost,
    String bodyPost,
    LocalDateTime createdDatePost,
    LocalDateTime updatedDatePost
) {

    public static PostOutputDto from(Post post){
        return new PostOutputDto(
           post.getPostId().value(),
           CategoryOutputDto.from(post.getCategoryOfPost()),
           post.getTitlePost(),
           post.getSubTitlePost(),
           post.getBodyPost(),
           post.getCreatedDatePost(),
           post.getUpdatedDatePost()
        );
    }
}
