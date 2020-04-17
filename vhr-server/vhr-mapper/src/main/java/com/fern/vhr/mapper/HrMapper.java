package com.fern.vhr.mapper;

import com.fern.vhr.model.Hr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUserName(String username);

    List<Hr> getAllHr(@Param("id") Integer id, @Param("keywords") String keywords);

    Integer deleteRolesById(@Param("hrid") Integer hrid, @Param("rid") Integer rid);

    void deleteAllHrRoles(@Param("hrid") Integer hrid);

    Integer insertHrRoles(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);

    Integer deleteHrById(Integer id);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    Integer getIdByName(@Param("keywords") String keywords);
}