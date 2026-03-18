package com.carblog.principalblog.infrastructure.persistence.repository;

import com.carblog.principalblog.domain.entity.Category;
import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.domain.repository.PostRepository;
import com.carblog.principalblog.infrastructure.persistence.entity.CategoryJpa;
import com.carblog.principalblog.infrastructure.persistence.entity.PostJpa;
import com.carblog.principalblog.infrastructure.persistence.mapper.CategoryMapper;
import com.carblog.principalblog.infrastructure.persistence.mapper.PostMapper;
import com.carblog.principalblog.infrastructure.persistence.springdata.CategoryJpaRepository;
import com.carblog.principalblog.infrastructure.persistence.springdata.PostJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;


    public PostRepositoryImpl(PostJpaRepository postJpaRepository, CategoryJpaRepository categoryJpaRepository){
        this.postJpaRepository = postJpaRepository;
        this.categoryJpaRepository = categoryJpaRepository;
    }


    @Override
    public Post save(Post post) {
        PostJpa postJpa = PostMapper.toJpa(post);
        PostJpa saved = postJpaRepository.save(postJpa);
        return PostMapper.toEntity(saved, post.getCategoryOfPost());
    }

    @Override
    public Optional<Post> findById(UUID id) {
        return postJpaRepository.findById(id).map(postJpa -> {
            CategoryJpa categoryJpa = categoryJpaRepository
                    .findById(postJpa.getIdCategory())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            Category category = CategoryMapper.toEntity(categoryJpa);
            return PostMapper.toEntity(postJpa, category);
        });
    }

    @Override
    public List<Post> findAll() {
        return postJpaRepository.findAll().stream().map(postJpa -> {
            CategoryJpa categoryJpa = categoryJpaRepository
                    .findById(postJpa.getIdCategory())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            return PostMapper.toEntity(postJpa, CategoryMapper.toEntity(categoryJpa));
        }).toList();
    }

    @Override
    public void delete(UUID id) {
        postJpaRepository.deleteById(id);
    }
}
