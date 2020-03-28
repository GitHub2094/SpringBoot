package com.lsm.frame.controller;

import com.lsm.frame.mapper.CategoryMapper;
import com.lsm.frame.model.entity.Category;
import com.lsm.frame.service.intf.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/index")
    public String index(Model m) {
        Category category = new Category();
        category = categoryService.selectByPrimaryKey(3);
        System.out.println(",,,"+category);
        m.addAttribute("category",category);
        return "index";
    }
}
