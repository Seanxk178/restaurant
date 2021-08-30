package com.aaa.service;

import com.aaa.mapper.ZygDetailsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ZygDetailsServiceImpl implements ZygDetailsService  {

    @Resource
    private ZygDetailsMapper zygDetailsMapper;
    @Override
    public List<Map> details(Integer o_id) {
        return zygDetailsMapper.details(o_id);
    }

    @Override
    public List<Map> selcomments(Map map) {
        return zygDetailsMapper.selcomments(map);
    }

    @Override
    public Integer selcommentsCount(Map map) {
        return zygDetailsMapper.selcommentsCount(map);
    }

    @Override
    public Boolean evaluate(Integer o_id) {
        Boolean state = false;
        //查询时间是否匹配
        Integer time = zygDetailsMapper.time(o_id);
        if(time==1){
            //商品是否已上完
            Integer num = zygDetailsMapper.getOrderLength(o_id);
            if(num==0){
                //是否已经评论过
                Integer past = zygDetailsMapper.criticPast(o_id);
                if(past==0){
                    state = true;
                }
            }
        }
        return state;
    }

    @Override
    public Integer addComment(Map map) {
        return zygDetailsMapper.addComment(map);
    }
}
