/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2020/3/6 5:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.HrMapper;
import com.fern.vhr.mapper.RoleMapper;
import com.fern.vhr.model.Hr;
import com.fern.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/6
 * @since 1.0.0
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    private HrMapper hrMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Hr hr=hrMapper.loadUserByUserName(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(roleMapper.getRoleByHrId(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHr(String keywords) {
        return hrMapper.getAllHr(HrUtils.getHr().getId(),keywords);
    }

    public Integer updateEnabled(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer deleteRolesById(Integer hrid, Integer rid) {
        return hrMapper.deleteRolesById(hrid, rid);
    }

    public boolean updateHrRoles(Integer hrid, Integer[] rids) {
        hrMapper.deleteAllHrRoles(hrid);
        Integer result= hrMapper.insertHrRoles(hrid, rids);
        return result == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteHrById(id);
    }

    public Integer getIdByName(String keywords) {
        return hrMapper.getIdByName(keywords);
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }
}