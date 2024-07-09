package com.example.ch5_1.controller;

import com.example.ch5_1.model.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestValidatorController {
    @RequestMapping(value="/add")
    public String add(@ModelAttribute("goodsInfo") @Validated Goods goods, BindingResult rs){
        //@ModelAttribute("goodsInfo")与th:object="${goodsInfo}"相对应
        if(rs.hasErrors()){//验证失败
            return "testValidator";
        }
        //验证成功，可以到任意地方，在这里直接到testValidator界面
        return "testValidator";
    }
}
