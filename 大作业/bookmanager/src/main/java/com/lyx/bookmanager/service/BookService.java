package com.lyx.bookmanager.service;

import com.lyx.bookmanager.mapper.BookMapper;
import com.lyx.bookmanager.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    public Page<Book> getAllBooks(int page, int size) {
        List<Book> book=bookMapper.getAllBook();
        int start=(page-1)*size;
        int end=Math.min(start+size,book.size());
        Sort sort = Sort.by(Sort.Direction.ASC, "bookId");
        if(page < 1) { page = 1; }
        // 在PageRequest里，page的值是从0（第1页）开始数的
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Book> bookPage=new PageImpl<>(book.subList(start,end),pageable,book.size());
        return bookPage;
    }
    public List<Book> getAllBooks(){
        return bookMapper.getAllBook();
    }
    public Book getBookById(String id){
        return bookMapper.getBookById(id);
    }
    public void updateBook(Book book){
        bookMapper.updateBook(book);
    }
    public void deleteBook(Long id){
        bookMapper.deleteBook(id);
    }
    public void addBook(Book book){
        bookMapper.addBook(book);
    }
    public void updateBookState(String id,int state){
        bookMapper.updateBookState(id, state);
    }
    public List<Book> searchBook(String keyword){
        return bookMapper.searchBook(keyword);
    }
    public Page<Book> searchBooks(String keyword,int page, int size) {
        List<Book> book=bookMapper.searchBook(keyword);
        int start=(page-1)*size;
        int end=Math.min(start+size,book.size());
        Sort sort = Sort.by(Sort.Direction.ASC, "bookId");
        if(page < 1) { page = 1; }
        // 在PageRequest里，page的值是从0（第1页）开始数的
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Book> bookPage=new PageImpl<>(book.subList(start,end),pageable,book.size());
        return bookPage;
    }
    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }
}
