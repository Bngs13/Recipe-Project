package com.group.artifact.controller;

import com.group.artifact.exception.NotFoundExceptionCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//20190209, Exception Handling for all controllers
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception e){
        log.error("Number Format Exception");
        log.error(e.getMessage());

        ModelAndView model=new ModelAndView();
        model.setViewName("400");
        model.addObject("exception",e);
        return model;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundExceptionCustom.class)
    public ModelAndView handleNotFound(Exception e){
        log.error("404 Not Found Exception");
        log.error(e.getMessage());
        ModelAndView model= new ModelAndView();
        model.setViewName("404");
        model.addObject("exception",e);
        return model;
    }
}
