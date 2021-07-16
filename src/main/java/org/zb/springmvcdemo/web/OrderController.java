package org.zb.springmvcdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zb.springmvcdemo.service.AsyncService;
import org.zb.springmvcdemo.service.AsyncServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {
    @Autowired
    private AsyncService asyncService;
    /**
     * 测试异步执行service
     */
    @GetMapping("/async")
    @ResponseBody
    public void async(){
        asyncService.executeAsync();
    }
    @PostMapping("/order")
    public String order(RedirectAttributes attr){
        System.out.println("进入order");
        attr.addFlashAttribute("site","www.zb.org");
        attr.addAttribute("name","bing");
        return "redirect:/orderlist";
    }
    @GetMapping("/orderlist")
    @ResponseBody
    public String orderList(Model model){
        System.out.println("进入orderlist");
        return (String) model.getAttribute("site");
    }
    /* version-1
    @PostMapping("/order")
    public String order(HttpServletRequest request){
        System.out.println("进入order");
        FlashMap flashMap = (FlashMap) request.getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE);
        flashMap.put("name","bing");
        return "redirect:/orderlist";
    }
    @GetMapping("/orderlist")
    @ResponseBody
    public String orderList(Model model){
        System.out.println("进入orderlist");
        return (String) model.getAttribute("name");
    }

     */
}
