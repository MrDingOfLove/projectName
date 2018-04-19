package com.ding.ssm.controller.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        //实现将日期字符串转换为Date类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //转换成功返回
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
