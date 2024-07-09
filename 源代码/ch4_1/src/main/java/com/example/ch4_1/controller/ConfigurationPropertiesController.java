package com.example.ch4_1.controller;

import com.example.ch4_1.model.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationPropertiesController {
	 @Autowired
	 StudentProperties studentProperties;
	 @RequestMapping("/testConfigurationProperties")
	 public String  testConfigurationProperties() {

	 	return studentProperties.toString();
	 }
}
