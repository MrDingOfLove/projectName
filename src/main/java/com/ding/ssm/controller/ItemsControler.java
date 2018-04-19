package com.ding.ssm.controller;

import com.ding.ssm.pojo.ItemsCustom;
import com.ding.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ItemsControler {
    @Autowired
    private ItemsService itemsService;

    //商品列表
    @RequestMapping("/items")
    public ModelAndView queryItems() throws Exception{
        List<ItemsCustom> itemsCustomsList = itemsService.selectItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsCustomsList);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
    //商品修改页面(展示)
//    @RequestMapping("/editItem")
    @RequestMapping(value="/editItem",method = {RequestMethod.GET})
    public String editItem(Model model,@RequestParam(value="id",defaultValue = "1") Integer item_id) throws Exception{
        //调用Service根据id查询商品信息
        ItemsCustom itemsCustom = itemsService.selectItemById(item_id);
        model.addAttribute("itemsCustom",itemsCustom);
        return "items/editItems";
    }
    //商品信息修改提交
    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Integer id,ItemsCustom itemsCustom) throws Exception{
        //调用Service根据id查询商品信息
        itemsService.updateItemById(id,itemsCustom);
        //重定向 url发生变化 request 不能共享
        return "redirect:items";
        //页面转发 url不发生变化 request 共享
//        return "forward:items";
    }
}
