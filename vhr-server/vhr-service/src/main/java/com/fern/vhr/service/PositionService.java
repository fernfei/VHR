/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: PositionService
 * Author:   Administrator
 * Date:     2020/3/12 17:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.PositionMapper;
import com.fern.vhr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/12
 * @since 1.0.0
 */
@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;
    public List<Position> getPositionAll() {
        return positionMapper.getPositionAll();
    }

    public Integer addPosition(Position position) {
        position.setCreatedate(new Date());
        position.setEnabled(true);
        return positionMapper.insert(position);
    }

    public Integer updatePosition(Position position) {
        position.setCreatedate(new Date());
        return positionMapper.updateByPrimaryKey(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deleteByIds(ids);
    }
}