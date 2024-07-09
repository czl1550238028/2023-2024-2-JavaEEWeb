package com.example.ch5_3.controller;

import java.sql.SQLException;

import com.example.ch5_3.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BaseController {
	@ExceptionHandler(value=Exception.class)
	public String handlerException(Exception e) {
		//数据库异常
		if (e instanceof SQLException) {
			return "sqlError";
		} else if (e instanceof MyException) {//自定义异常
			return "myError";
		} else {//未知异常
			return "noError";
		}
	}
}
