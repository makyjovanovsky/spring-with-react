package com.example.lab.entity.dto;

import com.example.lab.entity.BookEntity;
import com.example.lab.entity.enums.Category;

public class BookDTO {


    private String name;


    private Category category;


    private Long authorId;


    private int availableCopies;

    public BookDTO(String name, Category category, Long authorId, int availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDTO(BookEntity bookEntity) {

        this.name = bookEntity.getName();
        this.category = bookEntity.getCategory();
        this.authorId = bookEntity.getAuthor().getId();
        this.availableCopies = bookEntity.getAvailableCopies();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
