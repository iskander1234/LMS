package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_order",
        initialValue = 1,
        allocationSize = 1
)
public class Order extends AuditModel {
    @Column(name = "passed_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Almaty")
    private Date passedDate;

    @Column(name = "passing_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Almaty")
    private Date passingDate;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Client client;

    @ManyToOne
    private  Library library;

    public Order() {
    }

    public Order(Date passedDate, Date passingDate, Book book, Client client, Library library) {
        this.passedDate = passedDate;
        this.passingDate = passingDate;
        this.book = book;
        this.client = client;
        this.library = library;
    }

    public Date getPassedDate() {
        return passedDate;
    }

    public void setPassedDate(Date passedDate) {
        this.passedDate = passedDate;
    }

    public Date getPassingDate() {
        return passingDate;
    }

    public void setPassingDate(Date passingDate) {
        this.passingDate = passingDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
