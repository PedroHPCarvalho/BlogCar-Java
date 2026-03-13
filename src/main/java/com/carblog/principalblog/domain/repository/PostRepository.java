package com.carblog.principalblog.domain.repository;

import com.carblog.principalblog.domain.entity.Post;
import com.carblog.principalblog.domain.valueobject.Id;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post save(Post post);
    Optional<Post> findById (Id id);
    List<Post> findAll();
    void delete(Id id);
}
