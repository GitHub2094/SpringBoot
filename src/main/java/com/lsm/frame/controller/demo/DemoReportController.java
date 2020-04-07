package com.lsm.frame.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 报表
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/demo/report")
public class DemoReportController
{

    /**
     * 百度ECharts
     */
    @GetMapping("/echarts")
    public String echarts()
    {
        return "demo/report/echarts";
    }

    /**
     * 图表插件
     */
    @GetMapping("/peity")
    public String peity()
    {
        return  "demo/report/peity";
    }

    /**
     * 线状图插件
     */
    @GetMapping("/sparkline")
    public String sparkline()
    {
        return  "demo/report/sparkline";
    }

    /**
     * 图表组合
     */
    @GetMapping("/metrics")
    public String metrics()
    {
        return"demo/report/metrics";
    }
}
