package org.example.tpo_04_02;

import org.example.tpo_04_02.entity.*;
import org.example.tpo_04_02.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataPolluter {

    @Bean
    public CommandLineRunner populateDatabase(IUserRepository userRepository,
                                              IRoleRepository roleRepository,
                                              IBlogRepository blogRepository,
                                              IArticleRepository articleRepository) {
        return args -> {
            // Create 20 Roles
            List<Role> roles = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                Role role = new Role("Role_" + i);
                roles.add(role);
                roleRepository.save(role);
            }

            // Create 20 Users and assign two roles to each
            List<User> users = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                User user = new User("user" + i + "@example.com");
                // For example, assign role i and role i+1 (with wrap-around)
                user.addRole(roles.get((i - 1) % roles.size()));
                user.addRole(roles.get(i % roles.size()));
                users.add(user);
                userRepository.save(user);
            }

            // Create 20 Blogs, each managed by a unique user
            List<Blog> blogs = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                User manager = users.get(i - 1);
                Blog blog = new Blog("Blog_" + i, manager);
                blogs.add(blog);
                blogRepository.save(blog);
                // Set the managed blog on the user (inverse side)
                manager.setManagedBlog(blog);
                userRepository.save(manager);
            }

            // Create 20 Articles, each assigned to a user and a blog
            for (int i = 1; i <= 20; i++) {
                User author = users.get((i - 1) % users.size());
                Blog blog = blogs.get((i - 1) % blogs.size());
                Article article = new Article("Article_" + i);
                article.setAuthor(author);
                article.setBlog(blog);
                articleRepository.save(article);
            }
        };
    }
}
