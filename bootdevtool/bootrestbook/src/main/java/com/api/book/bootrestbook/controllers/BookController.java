package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookServices;
// @Controller
@RestController
public class BookController {

    // @RequestMapping(value="/book",method=RequestMethod.GET)
    // @ResponseBody
    // @GetMapping("/books")
    // public Book getBooks(){

    //     Book book = new Book();
    //     book.setId(12345);
    //     book.setTittle("this is java books");
    //     book.setAuthor("md afroz alam");


    //     return book;
    // }

    @Autowired
    private BookServices bookServices;

    // @GetMapping("/books")
    // public List<Book> getAllBooks(){

    //     return bookServices.getBooks();
    // }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        
        List<Book>list = bookServices.getBooks();
        return ResponseEntity.status(401).header("name", "md afroz alam").body(list);
    }

    @GetMapping("books/{id}")
    
    public Book getOne(@PathVariable("id") int id){

        return bookServices.getOneBooks(id);
    }

    @PostMapping("/books")
    public Book postOne(@RequestBody Book book){
            bookServices.addBook(book);
            return book;
    }

    @DeleteMapping("/books/{id}")

    public void deleteOne(@PathVariable ("id") int bookId){
        bookServices.deleteBook(bookId);
    }

    @PutMapping("/books/{id}")
    public void updateOne(@RequestBody Book book,@PathVariable ("id") int bookId){
        bookServices.updateBook(book, bookId);
    }

    
}
