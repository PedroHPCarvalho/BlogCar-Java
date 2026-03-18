package com.carblog.principalblog.api.response;

import com.carblog.principalblog.application.dto.PostOutputDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostResponse(
        UUID id,
        UUID categoryId,
        String titlePost,
        String subTitlePost,
        String bodyPost,
        LocalDateTime createdDatePost,
        LocalDateTime updatedDatePost
) {
    public static PostResponse fromPostOutputDto(PostOutputDto postOutputDto){
        return new PostResponse(
          postOutputDto.id(),
          postOutputDto.category().id(),
          postOutputDto.titlePost(),
          postOutputDto.subTitlePost(),
          postOutputDto.bodyPost(),
          postOutputDto.createdDatePost(),
          postOutputDto.updatedDatePost()
        );
    }
}
