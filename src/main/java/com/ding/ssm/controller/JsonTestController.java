package com.ding.ssm.controller;

import com.ding.ssm.pojo.extend.ItemsExtend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {
    //jsontest页面显示
    @RequestMapping("/jsontest")
    public String jsonTest(){
        return "jsontest";
    }
    //请求json(商品信息) 输出json(商品信息)
    /**
     * @RequestBody 将json转换为pojo对象
     * @ResponseBody 将pojo对象转成json
     */
    @ResponseBody
    @RequestMapping("/requestJson")
    public ItemsExtend requestJson(@RequestBody ItemsExtend itemsExtend){
        return itemsExtend;
    }
    @ResponseBody
    @RequestMapping("/requestKeyValue")
    public ItemsExtend requestKeyValue(ItemsExtend itemsExtend){
        return itemsExtend;
    }
}
