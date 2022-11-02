package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;
    private String blogName;
    private String content;
    private Author author;
    private MultipartFile link;
    private Category category;

    public BlogForm(Long id, String blogName, String content, Author author, MultipartFile link) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.link = link;
    }

    public BlogForm(Long id, String blogName, String content, Author author,  Category category,MultipartFile link) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.link = link;
        this.category = category;
    }

    public BlogForm(Long id, String blogName, String content, Author author, Category category) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public BlogForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
