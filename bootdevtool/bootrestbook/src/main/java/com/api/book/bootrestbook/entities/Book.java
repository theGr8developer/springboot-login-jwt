package com.api.book.bootrestbook.entities;

import jakarta.annotation.Generated;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
//to change table name
// @Table(name = "book")
public class Book {
    
    private
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    //To change column name
    // @Column(name="book_id")
    String tittle;
    String author;
    public Book(int id, String tittle, String author) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
    }
    public Book() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTittle() {
        return tittle;
    }
    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", tittle=" + tittle + ", author=" + author + "]";
    }
    
}
