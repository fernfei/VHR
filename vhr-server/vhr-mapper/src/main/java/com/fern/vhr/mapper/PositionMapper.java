package com.fern.vhr.mapper;

import com.fern.vhr.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getPositionAll();

    int addPosition(Position position);

    /***
     * Mybatis中的@param注解的使用场景：
     *
     * 1、方法有多个参数
     * 2、方法参数要取别名
     * 3、XML 中的 SQL 使用了 $
     * 4、动态sql中参数是非自定义pojo类型
     * @param ids
     * @return
     */
    Integer deleteByIds(@Param("ids") Integer[] ids);

}