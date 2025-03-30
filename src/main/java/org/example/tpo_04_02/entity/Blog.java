package org.example.tpo_04_02.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Article> articles = new HashSet<>();

    public Blog() {}

    public Blog(String name, User manager) {
        this.name = name;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public User getManager() {
        return manager;
    }
    public void setManager(User manager) {
        this.manager = manager;
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

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", articles=" + articles +
                '}';
    }
}