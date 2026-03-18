package com.carblog.principalblog.infrastructure.persistence.repository;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.repository.CategoryRepository;
import com.carblog.principalblog.infrastructure.persistence.entity.CategoryJpa;
import com.carblog.principalblog.infrastructure.persistence.mapper.CategoryMapper;
import com.carblog.principalblog.infrastructure.persistence.springdata.CategoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryRepositoryImpl (CategoryJpaRepository categoryJpaRepository){
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryJpa categoryJpa = CategoryMapper.toJpa(category);
        CategoryJpa categorySaved = categoryJpaRepository.save(categoryJpa);
        return CategoryMapper.toEntity(categorySaved);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryJpaRepository.findById(id).map(CategoryMapper::toEntity);
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepository.findAll().stream().map(CategoryMapper::toEntity).toList();
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryJpaRepository.findByNameCategory(name).map(CategoryMapper::toEntity);
    }

    @Override
    public void delete(UUID id) {
        categoryJpaRepository.deleteById(id);
    }
}
