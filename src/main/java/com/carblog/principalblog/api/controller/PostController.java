package com.carblog.principalblog.api.controller;

import com.carblog.principalblog.api.request.CreatePostRequest;
import com.carblog.principalblog.api.request.UpdatePostRequest;
import com.carblog.principalblog.api.response.PostResponse;
import com.carblog.principalblog.application.dto.PostInputDto;
import com.carblog.principalblog.application.dto.PostOutputDto;
import com.carblog.principalblog.application.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {
    private final CreatePostUseCase createPostUseCase;
    private final FindAllPostUseCase findAllPostUseCase;
    private final FindByIdPostUseCase findByIdPostUseCase;
    private final UpdatePostUseCase updatePostUseCase;
    private final DeletePostUseCase deletePostUseCase;

    public PostController(
            CreatePostUseCase createPostUseCase,
            FindAllPostUseCase findAllPostUseCase,
            FindByIdPostUseCase findByIdPostUseCase,
            UpdatePostUseCase updatePostUseCase,
            DeletePostUseCase deletePostUseCase
    ){
        this.createPostUseCase = createPostUseCase;
        this.findAllPostUseCase = findAllPostUseCase;
        this.findByIdPostUseCase = findByIdPostUseCase;
        this.updatePostUseCase = updatePostUseCase;
        this.deletePostUseCase = deletePostUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<PostResponse> createPost (@RequestBody CreatePostRequest createPostRequest){
        PostOutputDto postOutputDto = createPostUseCase.execute(CreatePostRequest.toDto(createPostRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(PostResponse.fromPostOutputDto(postOutputDto));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PostResponse> findByIdPost (@PathVariable UUID id){
        PostOutputDto postOutputDto = findByIdPostUseCase.execute(id.toString());
        return ResponseEntity.status(HttpStatus.OK).body(PostResponse.fromPostOutputDto(postOutputDto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PostResponse>> findAllPost (){
        List<PostOutputDto> postOutputDtos = findAllPostUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(postOutputDtos.stream().map(PostResponse::fromPostOutputDto).toList());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostResponse> updatePost (@RequestBody UpdatePostRequest updatePostRequest, @PathVariable UUID id){
        PostOutputDto postOutputDto = updatePostUseCase.execute(UpdatePostRequest.toDto(updatePostRequest));
        return ResponseEntity.status(HttpStatus.OK).body(PostResponse.fromPostOutputDto(postOutputDto));
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<Void> deleteByIdPost (@PathVariable UUID id){
        deletePostUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
