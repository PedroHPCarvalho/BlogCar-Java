package com.carblog.principalblog.application.usecase;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public DeleteCategoryUseCase(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void execute(String name){
        Optional<Category> categoryFinded = categoryRepository.findByName(name);
        if(categoryFinded.isEmpty()){
            throw new IllegalArgumentException();
        }
        categoryRepository.delete(categoryFinded.get().getCategoryId().value());
    }
}
