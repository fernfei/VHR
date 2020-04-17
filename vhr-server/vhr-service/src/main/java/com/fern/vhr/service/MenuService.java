/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MenuService
 * Author:   Administrator
 * Date:     2020/3/7 16:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.MenuMapper;
import com.fern.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/7
 * @since 1.0.0
 */
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getMenusByhrId(Integer id) {
        return menuMapper.getMenusByhrId(id);
    }

    public List<Menu> getMenuAll() {
        return menuMapper.getMenuAll();
    }
}