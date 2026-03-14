package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletePostUseCase {
    private final PostRepository postRepository;

    public DeletePostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void execute(UUID id){
        postRepository.delete(id);
    }
}
