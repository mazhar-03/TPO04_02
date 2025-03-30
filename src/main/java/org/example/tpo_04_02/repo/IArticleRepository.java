package org.example.tpo_04_02.repo;

import jakarta.transaction.Transactional;
import org.example.tpo_04_02.entity.Article;
import org.example.tpo_04_02.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IArticleRepository extends CrudRepository<Article, Long> {
    @Query("SELECT a FROM Article a")
    List<Article> listAllArticles();

    @Query("SELECT a FROM Article a WHERE a.author.id = :author_id")
    List<Article> findArticlesByAuthorId(Long author_id);

    @Query("SELECT a FROM Article a WHERE a.blog.id = :blog_id")
    List<Article> findArticlesByBlogId(Long blog_id);

    @Query("SELECT a FROM Article a WHERE LENGTH(a.title) < :number")
    List<Article> findArticlesByTitleLengthLessThan(int number);

    @Query("SELECT a FROM Article a WHERE LENGTH(a.title) > :number")
    List<Article> findArticlesByTitleLengthGreaterThan(int number);

    @Query(value = "SELECT * FROM Article", nativeQuery = true)
    List<Article> listAllArticlesNativeSQL();

    @Query("DELETE FROM Article a WHERE a.author.id = :author_id")
    @Modifying
    @Transactional
    void deleteArticlesByAuthorId(Long author_id);

    @Query("DELETE FROM Article a WHERE a.blog.id = :blog_id")
    @Modifying
    @Transactional
    void deleteArticlesByBlogId(Long blog_id);

    @Modifying
    @Transactional
    void deleteArticleById(Long id);
}
