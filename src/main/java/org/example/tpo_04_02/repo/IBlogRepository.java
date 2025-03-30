package org.example.tpo_04_02.repo;

import jakarta.transaction.Transactional;
import org.example.tpo_04_02.entity.Article;
import org.example.tpo_04_02.entity.Blog;
import org.example.tpo_04_02.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBlogRepository extends CrudRepository<Blog, Long> {
    @Query("SELECT b FROM Blog b")
    List<Blog> listAllBlogs();

    @Query("SELECT b.manager FROM Blog b WHERE b.manager.id = :manager_id")
    User getManagerByBlogId(Long manager_id);

    @Query("SELECT b FROM Blog b WHERE LENGTH(b.name) < :number")
    List<Blog> findBlogsByNameLengthLessThan(int number);

    @Query("SELECT b.name FROM Blog b")
    List<String> getAllBlogNames();

    @Modifying
    @Transactional
    @Query("DELETE FROM Blog b WHERE b.manager.id = :manager_id")
    void deleteBlogsByManagerId(Long manager_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Blog b WHERE b.name = :blog_name")
    void deleteBlogsByItsName(String blog_name);
}