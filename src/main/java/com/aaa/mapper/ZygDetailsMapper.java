package com.aaa.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZygDetailsMapper {

    public List<Map> details(Integer o_id);

    public List<Map> selcomments(Map map);

    public Integer selcommentsCount(Map map);

    public Integer time(Integer o_id);

    public Integer getOrderLength(Integer o_id);

    public Integer criticPast(Integer o_id);

    public Integer addComment(Map map);
}
