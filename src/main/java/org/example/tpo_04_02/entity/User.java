package org.example.tpo_04_02.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Article> articles = new HashSet<>();

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "manager", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Blog managedBlog;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Blog getManagedBlog() {
        return managedBlog;
    }

    public void setManagedBlog(Blog managedBlog) {
        this.managedBlog = managedBlog;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", articles=" + articles +
                ", roles=" + roles +
                ", blog=" + managedBlog +
                '}';
    }
}
