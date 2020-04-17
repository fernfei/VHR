package com.fern.vhr.mapper;

import com.fern.vhr.model.OpLog;
import com.fern.vhr.model.RespPageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    OpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);

    List<OpLog> getSystemLogs(@Param("page") Integer page,@Param("size") Integer size,@Param("hrid") Integer hrid);

    int getTotal();
}