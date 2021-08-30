package com.aaa.service;

import java.util.List;
import java.util.Map;

public interface ZygDetailsService {

    public  List<Map> details(Integer o_id);

    public List<Map> selcomments(Map map);

    public Integer selcommentsCount(Map map);

    public Boolean evaluate(Integer o_id);

    public Integer addComment(Map map);
}
