package org.example.tpo_04_02.repo;

import org.example.tpo_04_02.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface IArticleRepository extends CrudRepository<Article, Long> {
}
