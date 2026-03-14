package com.carblog.principalblog.domain.repository;

import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.domain.valueobject.Id;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository {

    Post save(Post post);
    Optional<Post> findById (UUID id);
    List<Post> findAll();
    void delete(UUID id);
}
