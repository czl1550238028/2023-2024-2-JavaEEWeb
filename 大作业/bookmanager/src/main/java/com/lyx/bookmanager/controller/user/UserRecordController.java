package com.lyx.bookmanager.controller.user;


import com.lyx.bookmanager.pojo.Book;
import com.lyx.bookmanager.pojo.Record;
import com.lyx.bookmanager.service.BookService;
import com.lyx.bookmanager.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.FileStore;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/record")
public class UserRecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private BookService bookService;
    @GetMapping("/getOwnRecord")
    public String getAllReaders(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int size,
                                Model model,HttpSession session) {
        String username = (String) session.getAttribute("username");
        Page<Record> recordsPage = recordService.getOwnRecords(username,page, size);
        model.addAttribute("records", recordsPage.getContent());
        model.addAttribute("totalPages", recordsPage.getTotalPages());
        model.addAttribute("number", recordsPage.getNumber()+1);
        model.addAttribute("totalElements", recordsPage.getTotalElements());
        return "user/ownRecord";
    }
    @RequestMapping ("/borrow/{bookId}")
    public String borrowBook(@PathVariable("bookId") String bookId, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Book book = bookService.getBookById(bookId);
        if (book != null && book.getState() == 1) { // 假设state=1表示书籍可借
            Record record = new Record();
            record.setBookId(Long.parseLong(bookId));
            record.setReaderId(Integer.parseInt((String) session.getAttribute("username"))); // 从session或者其他地方获取当前用户的ID
            record.setLendDate(new Date()); // 当前日期作为借出日期
            // 借阅记录的其他字段赋值...

            recordService.insertRecord(record); // 插入借阅记录
            bookService.updateBookState(bookId, 0); // 更新书籍状态为已借出
            model.addAttribute("result", "success");
        } else {
            model.addAttribute("result", "error");
        }
        return "redirect:/user/book/info/" + bookId; // 重定向回书籍信息页面
    }
    @RequestMapping("/return/{sernum}")
    public String returnBook(@PathVariable("sernum") Long sernum, Model model) {
        // 根据recordId获取对应的记录
        Record record = recordService.getRecordBySernum(sernum);
        if (record != null) {
            // 设置归还日期为当前日期
            record.setBackDate(new Date());
            // 更新记录
            recordService.updateRecord(record);
            // 将书籍状态更新为可借
            bookService.updateBookState(String.valueOf(record.getBookId()), 1);
            model.addAttribute("message", "书籍归还成功！");
        } else {
            model.addAttribute("error", "找不到对应的借阅记录。");
        }
        return "redirect:/user/record/getOwnRecord"; // 重定向到借阅记录页面
    }
}
