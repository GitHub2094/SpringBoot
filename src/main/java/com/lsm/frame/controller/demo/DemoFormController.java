package com.lsm.frame.controller.demo;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 表单相关
 *
 * @author lsm
 */
@Controller
@RequestMapping("/demo/form")
public class DemoFormController
{

    /**
     * 按钮页
     */
    @GetMapping("/button")
    public String button()
    {
        return  "demo/form/button";
    }

    /**
     * 下拉框
     */
    @GetMapping("/select")
    public String select()
    {
        return "demo/form/select";
    }

    /**
     * 时间轴
     */
    @GetMapping("/timeline")
    public String timeline()
    {
        return "demo/form/timeline";
    }

    /**
     * 表单校验
     */
    @GetMapping("/validate")
    public String validate()
    {
        return  "demo/form/validate";
    }

    /**
     * 功能扩展（包含文件上传）
     */
    @GetMapping("/jasny")
    public String jasny()
    {
        return "demo/form/jasny";
    }

    /**
     * 拖动排序
     */
    @GetMapping("/sortable")
    public String sortable()
    {
        return "demo/form/sortable";
    }

    /**
     * 选项卡 & 面板
     */
    @GetMapping("/tabs_panels")
    public String tabs_panels()
    {
        return  "demo/form/tabs_panels";
    }

    /**
     * 栅格
     */
    @GetMapping("/grid")
    public String grid()
    {
        return  "demo/form/grid";
    }

    /**
     * 表单向导
     */
    @GetMapping("/wizard")
    public String wizard()
    {
        return "demo/form/wizard";
    }

    /**
     * 文件上传
     */
    @GetMapping("/upload")
    public String upload()
    {
        return  "demo/form/upload";
    }

    /**
     * 日期和时间页
     */
    @GetMapping("/datetime")
    public String datetime()
    {
        return  "demo/form/datetime";
    }

    /**
     * 左右互选组件
     */
    @GetMapping("/duallistbox")
    public String duallistbox()
    {
        return  "demo/form/duallistbox";
    }

    /**
     * 基本表单
     */
    @GetMapping("/basic")
    public String basic()
    {
        return  "demo/form/basic";
    }

    /**
     * 卡片列表
     */
    @GetMapping("/cards")
    public String cards()
    {
        return   "demo/form/cards";
    }

    /**
     * summernote 富文本编辑器
     */
    @GetMapping("/summernote")
    public String summernote()
    {
        return  "demo/form/summernote";
    }

    /**
     * 搜索自动补全
     */
    @GetMapping("/autocomplete")
    public String autocomplete()
    {
        return "demo/form/autocomplete";
    }

}
