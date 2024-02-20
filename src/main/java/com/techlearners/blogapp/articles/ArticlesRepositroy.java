package com.techlearners.blogapp.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticlesRepositroy extends JpaRepository<ArticleEntity, Long> {
    ArticleEntity findBySlug(String slug);
}
