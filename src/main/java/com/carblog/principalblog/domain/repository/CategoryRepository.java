package com.carblog.principalblog.domain.repository;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.valueobject.Id;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Category save(Category category);
    Optional<Category> findById(UUID id);
    List<Category> findAll();
    Optional<Category> findByName(String name);
    void delete(UUID id);

}
