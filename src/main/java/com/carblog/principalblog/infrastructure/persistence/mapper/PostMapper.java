package com.carblog.principalblog.infrastructure.persistence.mapper;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.infrastructure.persistence.entity.PostJpa;

public class PostMapper {

    public static PostJpa toJpa(Post post){
        return new PostJpa(
                post.getPostId().value(),
                CategoryMapper.toJpa(post.getCategoryOfPost()),
                post.getTitlePost(),
                post.getSubTitlePost(),
                post.getBodyPost(),
                post.getCreatedDatePost(),
                post.getUpdatedDatePost()
                );
    }

    public static Post toEntity(PostJpa postJpa){
        Category category = CategoryMapper.toEntity(postJpa.getCategoryJpa());
        return Post.restore(
                postJpa.getId(),
                category,
                postJpa.getTitlePost(),
                postJpa.getSubTitlePost(),
                postJpa.getBodyPost(),
                postJpa.getCreatedDatePost(),
                postJpa.getUpdatedDatePost()
        );
    }
}
