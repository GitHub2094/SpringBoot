package com.lsm.frame.exception;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(AuthorizationException.class)
    public String ErrorHandler(Exception e, Model m) {
        m.addAttribute("message", "无权限");
        logger.warn("用户没有进入该页面的权限");
        return "login";
    }
}
