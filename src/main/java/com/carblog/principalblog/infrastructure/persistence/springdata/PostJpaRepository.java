package com.carblog.principalblog.infrastructure.persistence.springdata;

import com.carblog.principalblog.infrastructure.persistence.entity.PostJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostJpaRepository extends JpaRepository<PostJpa, UUID> {
}
