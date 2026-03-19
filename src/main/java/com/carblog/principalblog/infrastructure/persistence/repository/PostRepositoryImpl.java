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
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
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
        return PostMapper.toEntity(saved);
    }

    @Override
    public Optional<Post> findById(UUID id) {
        return postJpaRepository.findById(id).map(PostMapper::toEntity);
    }

    @Override
    public List<Post> findAll() {
        return postJpaRepository.findAll().stream().map(PostMapper::toEntity).toList();
    }

    @Override
    public void delete(UUID id) {
        postJpaRepository.deleteById(id);
    }
}
