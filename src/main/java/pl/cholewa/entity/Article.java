package pl.cholewa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author authorId;

    @ManyToMany
    @JoinTable(name = "articles_categories",
        joinColumns = @JoinColumn(name = "article_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id") )
    private List<Category> categories = new ArrayList<>();

    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;


    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated = LocalDateTime.now();
    }



}
