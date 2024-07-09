package com.lyx.bookmanager.controller.admin;


import com.lyx.bookmanager.pojo.Record;
import com.lyx.bookmanager.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/record")
public class AdminRecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/getAll")
    public String getAllReaders(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int size,
                                Model model) {
        Page<Record> recordsPage = recordService.getAllRecords(page, size);
        model.addAttribute("records", recordsPage.getContent());
        model.addAttribute("totalPages", recordsPage.getTotalPages());
        model.addAttribute("number", recordsPage.getNumber()+1);
        model.addAttribute("totalElements", recordsPage.getTotalElements());
        return "admin/records";
    }
}
