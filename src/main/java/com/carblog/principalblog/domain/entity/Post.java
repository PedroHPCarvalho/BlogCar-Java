package com.carblog.principalblog.domain.entity;

import com.carblog.principalblog.domain.valueobject.Id;
import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    //Atributos
    private Id postId;
    private Category categoryOfPost;
    private String titlePost;
    private String subTitlePost;
    private String bodyPost;
    private LocalDateTime createdDatePost;
    private LocalDateTime updatedDatePost;

    //Construtor privado
    private Post(Category category, String titlePost, String subTitlePost, String bodyPost){
        Objects.requireNonNull(category, "Category is Not Null");
        Objects.requireNonNull(titlePost, "Title is Not Null");
        Objects.requireNonNull(subTitlePost, "Subtitle is Not Null");
        Objects.requireNonNull(bodyPost, "Body is Not Null");
        this.postId = Id.newId();
        this.categoryOfPost = category;
        this.titlePost = titlePost;
        this.subTitlePost = subTitlePost;
        this.bodyPost = bodyPost;
        this.createdDatePost = LocalDateTime.now();
        this.updatedDatePost = LocalDateTime.now();
    }

    // Factory Method para gerar
    public static Post newPost(Category category, String titlePost, String subTitlePost, String bodyPost){
        return new Post(category, titlePost, subTitlePost, bodyPost);
    }

    public void updatePost(Category category, String titlePost, String subTitlePost, String bodyPost){
        Objects.requireNonNull(category, "Category is Not Null");
        Objects.requireNonNull(titlePost, "Title is Not Null");
        Objects.requireNonNull(subTitlePost, "Subtitle is Not Null");
        Objects.requireNonNull(bodyPost, "Body is Not Null");
        this.categoryOfPost = category;
        this.titlePost = titlePost;
        this.subTitlePost = subTitlePost;
        this.bodyPost = bodyPost;
        this.updatedDatePost = LocalDateTime.now();
    }



    // getter
    public Id getPostId() {
        return postId;
    }
    public Category getCategoryOfPost() {
        return categoryOfPost;
    }
    public String getTitlePost() {
        return titlePost;
    }
    public String getSubTitlePost() {
        return subTitlePost;
    }
    public String getBodyPost() {
        return bodyPost;
    }
    public LocalDateTime getCreatedDatePost() {
        return createdDatePost;
    }
    public LocalDateTime getUpdatedDatePost() {
        return updatedDatePost;
    }
}
