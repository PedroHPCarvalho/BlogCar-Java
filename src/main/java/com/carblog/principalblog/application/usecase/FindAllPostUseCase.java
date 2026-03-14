package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.application.dto.PostOutputDto;
import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPostUseCase {
    private final PostRepository postRepository;

    public FindAllPostUseCase (PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<PostOutputDto> execute(){
        return postRepository.findAll().stream().map(PostOutputDto::from).toList();
    }
}
