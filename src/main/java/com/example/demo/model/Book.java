package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_book",
        initialValue = 1,
        allocationSize = 1
)
public class Book extends AuditModel {
    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne
    private Library library;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
