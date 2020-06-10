package com.lsm.frame.utils.string;

import java.io.BufferedReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SuffixUntild {

    public static String generateSuffix() {
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
       /* int random = new Random().nextInt(10000);*/
        return new StringBuilder().append(formatDate).toString();
    }

    public static  String jobTitleSuffix() {
        String generateSuffix = SuffixUntild.generateSuffix();
        return new StringBuilder().append("新建作业").append(generateSuffix).toString();
    }


    public static String cjuSuffix() {
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyMMdd");
        // 转换为字符串
        String formatDate = format.format(new Date());
        /* int random = new Random().nextInt(10000);*/
        return new StringBuilder().append(formatDate).toString();
    }
}
