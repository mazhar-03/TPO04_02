package org.example.tpo_04_02.repo;

import org.example.tpo_04_02.entity.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepository extends CrudRepository<Blog, Long> {
}
