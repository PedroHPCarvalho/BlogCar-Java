package com.carblog.principalblog.domain.repository;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.valueobject.Id;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);
    Optional<Category> findById (Id id);
    List<Category> findAll();
    void delete(Id id);

}
