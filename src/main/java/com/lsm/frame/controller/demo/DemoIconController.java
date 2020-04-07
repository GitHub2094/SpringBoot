package com.lsm.frame.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo/icon")
public class DemoIconController
{

    /**
     * FontAwesome图标
     */
    @GetMapping("/fontawesome")
    public String fontAwesome()
    {
        return "demo/icon/fontawesome";
    }

    /**
     * Glyphicons图标
     */
    @GetMapping("/glyphicons")
    public String glyphicons()
    {
        return  "demo/icon/glyphicons";
    }
}
