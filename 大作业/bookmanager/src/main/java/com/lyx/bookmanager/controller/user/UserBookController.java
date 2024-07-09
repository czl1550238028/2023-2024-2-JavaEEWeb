package com.lyx.bookmanager.controller.user;

import com.lyx.bookmanager.pojo.Book;
import com.lyx.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/book")
public class UserBookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/getAll")
    public String getAllBooks(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        Page<Book> booksPage = bookService.getAllBooks(page, size);
        model.addAttribute("books", booksPage.getContent());
        model.addAttribute("totalPages", booksPage.getTotalPages());
        model.addAttribute("number", booksPage.getNumber()+1);
        model.addAttribute("totalElements", booksPage.getTotalElements());
        return "user/books";
    }

    @RequestMapping("/info/{id}")
    public String info(Model model, @PathVariable("id") String id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "user/book_info";
    }

    @GetMapping("/search")
    public String search(String keyword, @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        if(keyword==null){
            return "redirect:user/book/getAll";
        }
        Page<Book> booksPage = bookService.searchBooks(keyword,page, size);
        model.addAttribute("books", booksPage.getContent());
        model.addAttribute("totalPages", booksPage.getTotalPages());
        model.addAttribute("number", booksPage.getNumber()+1);
        model.addAttribute("totalElements", booksPage.getTotalElements());
        model.addAttribute("keyword", keyword);
        return "user/book_search_result";
    }
}
