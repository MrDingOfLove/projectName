package com.ding.ssm.controller;

import com.ding.ssm.controller.validation.ModifyScene;
import com.ding.ssm.pojo.extend.ItemsExtend;
import com.ding.ssm.pojo.query.ItemsQueryVo;
import com.ding.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ItemsControler {
    @Autowired
    private ItemsService itemsService;

    //商品列表
    @RequestMapping("/items")
    public String queryItems(Model model,ItemsQueryVo itemsQueryVo) throws Exception{
        //获取商品列表数据
        List<ItemsExtend> itemsCustomsList = itemsService.selectItemsList(itemsQueryVo);
        model.addAttribute("itemsList",itemsCustomsList);
        return "items/itemsList";
    }
    //商品修改页面(展示)
//    @RequestMapping("/editItem")
    @RequestMapping(value="/editItem",method = {RequestMethod.GET})
    public String editItem(Model model,@RequestParam(value="id",defaultValue = "1") Integer item_id) throws Exception{
        //调用Service根据id查询商品信息
        ItemsExtend itemsExtend = itemsService.selectItemById(item_id);
        model.addAttribute("item", itemsExtend);
        return "items/editItems";
    }
    //商品信息修改提交
    /**
     * 在需要验证的pojo参数前添加 @Validated，在需要验证的pojo后天添加 BindingResult bindingResult 参数 来接收错误信息
     * @Validated 和 BindingResult bindingResult 必须成对出现 参数顺序固定（一前一后）
     */
    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Model model, Integer id, @ModelAttribute("item") @Validated(value = {ModifyScene.class}) ItemsExtend itemsExtend, BindingResult bindingResult) throws Exception{
        //获取校验错误信息
        if (bindingResult.hasErrors()){
            //如果有错误，输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors){
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors",allErrors);
            return "items/editItems";
        }
        //调用Service根据id查询商品信息
        itemsService.updateItemById(id, itemsExtend);
        //重定向 url发生变化 request 不能共享
        return "redirect:items";
        //页面转发 url不发生变化 request 共享
        //return "forward:items";
    }
    //批量删除商品
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception{
        if (items_id!=null) {
            itemsService.deleteItems(items_id);
        }
        return "redirect:items";
    }
    //批量修改商品页面
    @RequestMapping("/modifyItems")
    public String modifyItems(Model model) throws Exception{
        //获取商品列表数据
        List<ItemsExtend> itemsCustomsList = itemsService.selectItemsList(null);
        model.addAttribute("itemsList",itemsCustomsList);
        return "items/modifyItemsList";
    }
    //批量修改商品提交
    @RequestMapping("/modifyItemsSubmit")
    public String modifyItemsSubmit(Integer[] items_id,ItemsQueryVo itemsQueryVo) throws Exception{
        if (items_id!=null){
            for (int i = 0; i < items_id.length; i++) {
                itemsService.updateItemById(items_id[i],findItemById(items_id[i],itemsQueryVo.getItemsList()));
            }
        }
        return "redirect:modifyItems";
    }
    //在itemsList 中找到 指定的item
    private ItemsExtend findItemById(Integer id, List<ItemsExtend> itemsList){
        for (ItemsExtend itemsExtend : itemsList){
            if (itemsExtend.getId() == id)
                return itemsExtend;
        }
        return null;
    }
}
