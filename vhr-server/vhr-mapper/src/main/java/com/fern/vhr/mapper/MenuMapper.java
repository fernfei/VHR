package com.fern.vhr.mapper;

import com.fern.vhr.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByhrId(Integer id);

    List<Menu> getMenuAll();

    List<Menu> getMenus();

    List<Integer> getMenuIdByrid(Integer rid);

    Integer deleteByRid(Integer rid);

    Integer insertByRid(@Param("rid") Integer rid, @Param("mids") Integer[] mids);

}