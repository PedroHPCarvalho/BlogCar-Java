package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.application.dto.PostInputDto;
import com.carblog.principalblog.application.dto.PostOutputDto;
import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.domain.repository.CategoryRepository;
import com.carblog.principalblog.domain.repository.PostRepository;
import com.carblog.principalblog.domain.valueobject.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePostUseCase {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public CreatePostUseCase (PostRepository postRepository, CategoryRepository categoryRepository){
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    public PostOutputDto execute(PostInputDto postInputDto){
        Id idSearch = Id.fromString(postInputDto.categoryId());
        Optional<Category> categoryFinded = categoryRepository.findById(idSearch.value());
        if(categoryFinded.isEmpty()){
            throw new IllegalArgumentException();
        }
        Post post = Post.newPost(categoryFinded.get(),postInputDto.titlePost(),postInputDto.subTitlePost(),postInputDto.bodyPost());
        postRepository.save(post);
        return PostOutputDto.from(post);
    }
}
