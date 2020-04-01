package com.lsm.frame.exception;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public String ErrorHandler(Exception e, Model m) {
        m.addAttribute("message", "无权限");
        return "login";
    }
}
