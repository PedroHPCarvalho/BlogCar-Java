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

@Service
public class UpdatePostUseCase {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public UpdatePostUseCase(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
     }

     public PostOutputDto execute(PostUpdateDto postUpdateDto) {
         // Lógica para atualizar um post
         Optional<Post> postSearch = postRepository.findById(Id.fromString(postUpdateDto.id()).value());
         if (postSearch.isEmpty()) {
             throw new IllegalArgumentException("Post não encontrado");
         }
         Post postToUpdate = postSearch.get();
         Optional<Category> categorySearch = Optional.ofNullable(categoryRepository.findById(Id.fromString(postUpdateDto.categoryId()).value()).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada")));
         postToUpdate.updatePost(categorySearch.get(), postUpdateDto.titlePost(), postUpdateDto.subTitlePost(), postUpdateDto.bodyPost());
         postRepository.save(postToUpdate);
         return PostOutputDto.from(postToUpdate);
     }
}
