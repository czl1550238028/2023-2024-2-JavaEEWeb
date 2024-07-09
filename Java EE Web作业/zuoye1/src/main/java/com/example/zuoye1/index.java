package com.example.zuoye1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class index {
    @GetMapping(value = "/index")
    public String hello(Model model) {
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(1, "校长", 24));
        empList.add(new Emp(2, "书记", 28));
        empList.add(new Emp(3, "小海", 25));
        model.addAttribute("empList", empList);
        return "index";
    }

}
