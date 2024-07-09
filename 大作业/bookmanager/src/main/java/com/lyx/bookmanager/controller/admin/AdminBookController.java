package com.lyx.bookmanager.controller.admin;


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
@RequestMapping("/admin/book")
public class AdminBookController {

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
        return "admin/books";
    }

    @RequestMapping("/info/{id}")
    public String info(Model model, @PathVariable("id") String id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "admin/book_info";
    }

    @RequestMapping("/toEditPage/{id}")
    public String toEditPage(Model model, @PathVariable("id") String id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "admin/book_edit";
    }

    @RequestMapping("/update")
    public String update(Book book) {
        bookService.updateBook(book);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "admin/book_add";
    }

    @RequestMapping("/add")
    public String add(Book book) {
        bookService.addBook(book);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/search")
    public String search(String keyword, @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        if(keyword==null){
            return "redirect:admin/book/getAll";
        }
        Page<Book> booksPage = bookService.searchBooks(keyword,page, size);
        model.addAttribute("books", booksPage.getContent());
        model.addAttribute("totalPages", booksPage.getTotalPages());
        model.addAttribute("number", booksPage.getNumber()+1);
        model.addAttribute("totalElements", booksPage.getTotalElements());
        model.addAttribute("keyword", keyword);
        return "admin/book_search_result";
    }

}
