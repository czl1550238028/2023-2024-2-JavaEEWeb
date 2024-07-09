package com.example.ch5_3.controller;

import java.sql.SQLException;

import com.example.ch5_3.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestHandleExceptionController{
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/db")
    public void db() throws SQLException {
        throw new SQLException("数据库异常");
    }
    @RequestMapping("/my")
    public void my() throws MyException {
        throw new MyException("自定义异常");
    }
    @RequestMapping("/no")
    public void no() throws Exception {
        throw new Exception("未知异常");
    }

}
