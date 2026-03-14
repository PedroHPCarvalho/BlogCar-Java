package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.application.dto.CategoryOutputDto;
import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategoriesUseCase {
    private final CategoryRepository categoryRepository;

    public FindAllCategoriesUseCase (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryOutputDto> execute(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryOutputDto::from).toList();
    }
}
