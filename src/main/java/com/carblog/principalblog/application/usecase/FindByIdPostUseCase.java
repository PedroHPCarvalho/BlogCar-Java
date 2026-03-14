package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.application.dto.PostOutputDto;
import com.carblog.principalblog.domain.repository.PostRepository;
import com.carblog.principalblog.domain.valueobject.Id;
import org.springframework.stereotype.Service;

@Service
public class FindByIdPostUseCase {
    private final PostRepository postRepository;

    public FindByIdPostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

     public PostOutputDto execute(String id){
        return postRepository.findById(Id.fromString(id).value())
                .map(PostOutputDto::from)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));
     }
}
