/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: PermissService
 * Author:   Administrator
 * Date:     2020/3/13 22:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.MenuMapper;
import com.fern.vhr.mapper.RoleMapper;
import com.fern.vhr.model.Menu;
import com.fern.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/13
 * @since 1.0.0
 */
@Service
public class PermissService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }

    public List<Menu> getMenus() {
        return menuMapper.getMenus();
    }

    public Integer addRole(Role role) {
        return roleMapper.insert(role);
    }

    public List<Integer> getMenuIdByrid(Integer rid) {
        return menuMapper.getMenuIdByrid(rid);
    }
    @Transactional
    public Boolean  insertMenuWithRole(Integer rid, Integer[] mids) {
        Integer integer = menuMapper.deleteByRid(rid);
        if (mids != null) {
            Integer result = menuMapper.insertByRid(rid, mids);
            return result == mids.length;
        }
        System.out.println(integer);
        return integer != -1 ? true : false;
    }

    public Integer deleteById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}