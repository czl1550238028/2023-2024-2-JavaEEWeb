package com.lyx.bookmanager.mapper;

import com.lyx.bookmanager.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    List<Book> getAllBook();
    Book getBookById(String id);
    void updateBook(Book book);
    void deleteBook(long id);
    void addBook(Book book);
    void updateBookState(String id,int state);
    List<Book> searchBook(String keyword);
}
