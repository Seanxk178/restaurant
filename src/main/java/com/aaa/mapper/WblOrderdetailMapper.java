package com.aaa.mapper;


import com.aaa.entity.Orderdetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface WblOrderdetailMapper {
    public List<Map> selectAll(Map<String,Object> map);
    public int selectCount(Map map);
    public List<Map> selectMessage(Map<String,Object> map);
    public List<Map> alldata(Map map);
}
