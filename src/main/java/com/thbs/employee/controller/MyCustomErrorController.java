package com.thbs.employee.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCustomErrorController implements ErrorController
{
	static final Logger logger = Logger.getLogger(MyCustomErrorController.class);
	
	private static final String PATH = "/error";
    
    @RequestMapping(value=PATH)
    public String error() {
    	
        return "Error heaven";
    }
 
    @Override
    public String getErrorPath() {
        return PATH;
    }
}
