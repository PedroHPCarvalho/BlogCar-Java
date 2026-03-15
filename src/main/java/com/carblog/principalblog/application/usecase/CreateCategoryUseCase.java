package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.application.dto.CategoryInputDto;
import com.carblog.principalblog.application.dto.CategoryOutputDto;
import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;

     public CreateCategoryUseCase (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryOutputDto execute(CategoryInputDto categoryInputDto){
        Optional<Category> categoryExistenceTest = categoryRepository.findByName(categoryInputDto.nameCategory());
        if (categoryExistenceTest.isPresent()){
            throw new IllegalArgumentException();
        }
        Category categoryCreated =  Category.newCategory(categoryInputDto.nameCategory());
        categoryRepository.save(categoryCreated);
        return CategoryOutputDto.from(categoryCreated);
    }
}
