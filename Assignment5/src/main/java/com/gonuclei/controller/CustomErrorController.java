package com.gonuclei.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Custom error controller.
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * Error message string.
     *
     * @return the string
     */
    @RequestMapping("/error")
    public String errorMessage(){
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        return "Error 404 Not Found!";
    }
}
