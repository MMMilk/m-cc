package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/picture")
public class FileController {

    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public ModelAndView go(){
        return new ModelAndView("file");
    }
}