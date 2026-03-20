package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.application.dto.PostOutputDto;
import com.carblog.principalblog.application.dto.PostUpdateDto;
import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.domain.repository.CategoryRepository;
import com.carblog.principalblog.domain.repository.PostRepository;
import com.carblog.principalblog.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdatePostUseCase {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public UpdatePostUseCase(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
     }

     public PostOutputDto execute(PostUpdateDto postUpdateDto, UUID id) {
         // Lógica para atualizar um post
         Post postSearch = postRepository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("Post Not Founded"));
         Category categorySearch = categoryRepository.findById(Id.fromString(postUpdateDto.categoryId()).value())
                 .orElseThrow(() -> new IllegalArgumentException("Category Not Founded"));
         postSearch.updatePost(categorySearch, postUpdateDto.titlePost(), postUpdateDto.subTitlePost(), postUpdateDto.bodyPost());
         postRepository.save(postSearch);
         return PostOutputDto.from(postSearch);
     }
}
