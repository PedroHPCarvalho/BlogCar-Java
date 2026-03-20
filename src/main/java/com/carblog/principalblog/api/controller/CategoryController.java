package com.carblog.principalblog.api.controller;

import com.carblog.principalblog.api.request.CreateCategoryRequest;
import com.carblog.principalblog.api.response.CategoryResponse;

import com.carblog.principalblog.application.dto.CategoryInputDto;
import com.carblog.principalblog.application.dto.CategoryOutputDto;
import com.carblog.principalblog.application.usecase.CreateCategoryUseCase;

import com.carblog.principalblog.application.usecase.DeleteCategoryUseCase;
import com.carblog.principalblog.application.usecase.FindAllCategoriesUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindAllCategoriesUseCase findAllCategoriesUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

    public CategoryController(
            CreateCategoryUseCase createCategoryUseCase,
            FindAllCategoriesUseCase findAllCategoriesUseCase,
            DeleteCategoryUseCase deleteCategoryUseCase
    ){
        this.createCategoryUseCase = createCategoryUseCase;
        this.findAllCategoriesUseCase = findAllCategoriesUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory (@RequestBody CreateCategoryRequest createCategoryRequest){
        CategoryInputDto categoryInputDto = CreateCategoryRequest.toDto(createCategoryRequest);
        CategoryOutputDto categoryOutputDto = createCategoryUseCase.execute(categoryInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponse.fromDto(categoryOutputDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findById (){
        return ResponseEntity.status(HttpStatus.OK).body(findAllCategoriesUseCase.execute().stream().map(CategoryResponse::fromDto).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById (@PathVariable("id") UUID id){
        deleteCategoryUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
