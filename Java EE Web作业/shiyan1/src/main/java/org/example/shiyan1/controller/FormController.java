package org.example.shiyan1.controller;

import org.example.shiyan1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class FormController {
    @RequestMapping("/form")
    public String form(Model model){
        setConstant(model);
        User user=new User();
        user.setName("小明");
        user.setSex(1);
        user.setMycolor(new String[]{"white","black"});
        model.addAttribute("user",user);
        return "form";
    }

    @RequestMapping ("/submit")
    public String submit(@ModelAttribute User user,Model model){
        setConstant(model);
        model.addAttribute("user",user);
        List<User> list=new ArrayList<User>();
        User user1=new User();
        user1.setName("admin");
        user1.setSex(1);
        user1.setMycolor(new String[]{"red","blue"});
        list.add(user1);
        list.add(user);
        model.addAttribute("users",list);
        return "list";
    }
    private void setConstant(Model model) {
        Map<String, Object> sexes=new HashMap<String,Object>();
        sexes.put("男",1);
        sexes.put("女",2);
        model.addAttribute("sexes",sexes);
        String[] colors=new String[]{"red","white","black"};
        model.addAttribute("colors",colors);
    }
}
