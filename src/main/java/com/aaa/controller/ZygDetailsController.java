package com.aaa.controller;

import com.aaa.service.ZygDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zyg")
public class ZygDetailsController {

    @Autowired
    private ZygDetailsService zygDetailsService;
    //小程序个人订单的结果
    @RequestMapping("/details")
    @ResponseBody
    public List<Map> details(Integer o_id){
        return zygDetailsService.details(o_id);
    }
    //查看评论的代码
    @RequestMapping("/selcomments")
    @ResponseBody
    public Map selcomments(Integer limit,String count,String prev,Integer page,String next,String skip,String neginDate,String endDate){
        Map m = new HashMap();
        m.put("limit",limit);
        m.put("start",(page-1)*limit);
        m.put("neginDate",neginDate);
        m.put("endDate",endDate);
        List<Map> mapList = zygDetailsService.selcomments(m);
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",zygDetailsService.selcommentsCount(m));
        map.put("data",mapList);
        return map;
    }
    //跳转评论页面
    @RequestMapping("/evaluate")
    @ResponseBody
    public Boolean evaluate(Integer o_id){
        return zygDetailsService.evaluate(o_id);
    }
    //添加评论
    @RequestMapping("/addComment")
    @ResponseBody
    public Integer addComment(Integer o_id,String content,Integer serve,Integer menu,Integer environment){
        Map map = new HashMap();
        map.put("o_id",o_id);
        map.put("content",content);
        map.put("serve",serve);
        map.put("menu",menu);
        map.put("environment",environment);
        return zygDetailsService.addComment(map);
    }
}
