package com.aaa.controller;

import com.aaa.entity.Orderdetail;
import com.aaa.entity.pageCount;
import com.aaa.entity.tableResult;
import com.aaa.service.WblOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wbl")
public class WblOrderdetailController {
    @Autowired
    private WblOrderdetailService wblOrderdetailService;

    @RequestMapping("/tables")
    public String meter(){
        return "wbltable";
    }
    //    查询数据
    @RequestMapping("listData")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount, Orderdetail orderdetail){
        String aaa=orderdetail.demoReload;
        String Obigen="";
        String Oend="";
        if(aaa!="" && aaa!=null){
            String arr[]= aaa.split("~");
             Obigen=arr[0];
             Oend=arr[1];
        }
        orderdetail.setObegin(Obigen);
        orderdetail.setOend(Oend);
        tableResult<Map> result=new tableResult<>();
        if(aaa == null){
            List<Map> list=wblOrderdetailService.selectAll(pageCount);
            //设置表格有多少条数据
            int count=wblOrderdetailService.selectCount(pageCount,orderdetail);
            result.setData(list);
            result.setCount(count);
            return result;
        }else{
//            System.out.println(orderdetail.getObegin()+","+orderdetail.getOend());
            List<Map> list = wblOrderdetailService.selectMessage(pageCount,orderdetail);
            //设置表格有多少条数据
            int count=wblOrderdetailService.selectCount( pageCount,orderdetail);
            result.setData(list);
            result.setCount(count);
            return result;
        }
    }
    @RequestMapping("AllData")
    @ResponseBody
    public tableResult<Map> alldata(String dataTime){
        Map map = new HashMap();
        if(dataTime != "" && dataTime != null){
            String[] split = dataTime.split("~");
            map.put("beginDate",split[0]);
            map.put("endDate",split[1]);
        }
        tableResult<Map> result=new tableResult<>();
        List<Map> list = wblOrderdetailService.alldata(map);
        result.setData(list);
        result.setCount(0);
        return result;
    }
}
