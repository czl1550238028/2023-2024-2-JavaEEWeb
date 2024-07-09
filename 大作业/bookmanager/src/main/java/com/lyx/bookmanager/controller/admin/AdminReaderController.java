package com.lyx.bookmanager.controller.admin;

import com.lyx.bookmanager.pojo.Book;
import com.lyx.bookmanager.pojo.Reader;
import com.lyx.bookmanager.service.ReaderService;
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
@RequestMapping("/admin/reader")
public class AdminReaderController {

    @Autowired
    private ReaderService readerService;


    @GetMapping("/getAll")
    public String getAllReaders(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        Page<Reader> readersPage = readerService.getAllReaders(page, size);
        model.addAttribute("readers", readersPage.getContent());
        model.addAttribute("totalPages", readersPage.getTotalPages());
        model.addAttribute("number", readersPage.getNumber()+1);
        model.addAttribute("totalElements", readersPage.getTotalElements());
        return "admin/readers";
    }
    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "admin/reader_add";
    }

    @RequestMapping("/add")
    public String add(Reader reader) {
        readerService.addReader(reader);
        return "redirect:/admin/reader/getAll";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int readerId) {
        readerService.deleteReader(readerId);
        return "redirect:/admin/reader/getAll";
    }
}
