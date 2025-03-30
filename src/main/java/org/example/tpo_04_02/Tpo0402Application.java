package org.example.tpo_04_02;

import org.example.tpo_04_02.entity.Article;
import org.example.tpo_04_02.entity.Blog;
import org.example.tpo_04_02.entity.Role;
import org.example.tpo_04_02.entity.User;
import org.example.tpo_04_02.repo.IArticleRepository;
import org.example.tpo_04_02.repo.IBlogRepository;
import org.example.tpo_04_02.repo.IRoleRepository;
import org.example.tpo_04_02.repo.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Set;

@SpringBootApplication
public class Tpo0402Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Tpo0402Application.class, args);

//ARTICLE OPERATIONS
/*       IArticleRepository articleRepository = context.getBean(IArticleRepository.class);

        //viewing and searching
        //    for(Article article : articleRepository.findAll())
//            System.out.println(article);

//        for(Article article : articleRepository.findArticlesByAuthorId(5L))
//            System.out.println(article);

//        for(Article article : articleRepository.findArticlesByTitleLengthLessThan(40))
//            System.out.println(article);

//        for(Article article : articleRepository.findArticlesByTitleLengthGreaterThan(55))
//            System.out.println(article);

//        for (Article article : articleRepository.findArticlesByBlogId(5L))
//            System.out.println(article);

//        for (Article article : articleRepository.listAllArticlesNativeSQL())
//            System.out.println(article);

        //adding
        Article article = new Article("mazo12's book");
        article.setAuthor(new User("altincvay@gmail.com"));
        article.setBlog(new Blog("SEA2"));
        articleRepository.save(article);

        //deleting
        articleRepository.deleteArticlesByAuthorId(21L);

*/

//BLOG OPERATIONS
/*        IBlogRepository blogRepository = context.getBean(IBlogRepository.class);
//viewing and searching

//        System.out.println(blogRepository.getManagerByBlogId(21L));

//        for (Blog blog : blogRepository.findAll()) {
//            System.out.println(blog);
//        }

//        for (Blog blog : blogRepository.findBlogsByNameLengthLessThan(11))
//            System.out.println(blog);

//        System.out.println(blogRepository.getManagerByBlogId(5L));

//        for(String s : blogRepository.getAllBlogNames())
//            System.out.println(s);

//adding
//        User user = new User("aloha@gmail.com");
//        user.setRoles(null);
//        user.setArticles(null);
//        IUserRepository userRepository = context.getBean(IUserRepository.class);
//        userRepository.save(user);
//        Blog blog = new Blog("My Blog");
//        blog.setManager(user);
//        blog.setArticles(null);
//        blogRepository.save(blog);

//deleting
//        blogRepository.deleteById(21L);
        blogRepository.deleteBlogsByItsName("My Blog");*/

//USER OPERATIONS
/*        IUserRepository userRepository = context.getBean(IUserRepository.class);
//viewing and searching
//        for(User user : userRepository.listALLUsers())
//            System.out.println(user);

//        for(String s : userRepository.listAllEmailsStartsWithGivenParameter('a'))
//            System.out.println(s);

//        for (User user : userRepository.listAllUsersWithTheirEmailsLexicographically())
//            System.out.println(user);

//        System.out.println(userRepository.findUserById(21L));

// deleting
//        userRepository.deleteById(21L);
//        userRepository.deleteUserByItsEmail("aloha@gmail.com");*/

//ROLE OPERATIONS
/*        IRoleRepository roleRepository = context.getBean(IRoleRepository.class);
//viewing and searching
//        for (Role role : roleRepository.listAllRoles())
//            System.out.println(role);

//        for (String name : roleRepository.listAllRolesNames())
//            System.out.println(name);

//        System.out.println(roleRepository.findRoleIdByName("Intern"));
//        System.out.println(roleRepository.findRoleNameById(12L));

//adding
//        Role role = new Role("Security2");
//        role.addUser(null);
//        roleRepository.save(role);

//delete
//        roleRepository.deleteRoleByName("Security");
//        roleRepository.deleteRoleById(24L);*/

        SpringApplication.run(Tpo0402Application.class, args);
    }

}
