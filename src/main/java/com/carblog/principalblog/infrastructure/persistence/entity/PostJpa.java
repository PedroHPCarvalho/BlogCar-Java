package com.carblog.principalblog.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostJpa {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private UUID idCategory;
    private String titlePost;
    private String subTitlePost;
    private String bodyPost;
    private LocalDateTime createdDatePost;
    private LocalDateTime updatedDatePost;
}
