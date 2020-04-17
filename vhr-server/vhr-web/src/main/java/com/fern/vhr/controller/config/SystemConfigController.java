/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MenuController
 * Author:   Administrator
 * Date:     2020/3/7 15:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fern.vhr.model.Hr;
import com.fern.vhr.model.Menu;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public RespBean getMenusByhrId(Authentication authentication) throws JsonProcessingException {
        //Authentication 是SpringSecurity的核心类里面存储着已登陆用户的信息
        Integer id = ((Hr) authentication.getPrincipal()).getId();
        List<Menu> menus = menuService.getMenusByhrId(id);
        return RespBean.getSuccess(null, menus);
    }

}