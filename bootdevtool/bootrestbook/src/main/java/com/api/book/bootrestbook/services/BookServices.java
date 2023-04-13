package com.api.book.bootrestbook.services;
import com.api.book.bootrestbook.entities.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;;

@Component
public class BookServices {
    
    private
    static List<Book>list = new ArrayList<Book>();

    static{
        
        list.add(new Book(1,"java developer","xyz"));
        list.add(new Book(2,"cpp developer","abc"));
        list.add(new Book(3,"python developer","lmn"));
    }

    public List<Book>getBooks(){
        return list;
    }

    public Book getOneBooks(int id){
       Book book = null;
         book =     list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    public Book addBook(Book book){
        list.add(book);
        System.out.println(book);
        return book;
    }

    public void deleteBook(int bookId){
        list = list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
    }

    public void updateBook(Book book,int bookId){

        list=list.stream().map(book1->{
            if(book1.getId()==bookId){
                book1.setTittle(book.getTittle());
                book1.setAuthor(book.getAuthor());
                return book1;
            }else{
                return book1;
            }

        }).collect(Collectors.toList());
    }


}
