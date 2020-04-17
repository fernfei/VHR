/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: PermissController
 * Author:   Administrator
 * Date:     2020/3/13 22:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system.basic;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.model.Role;
import com.fern.vhr.service.PermissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    private PermissService permissService;

    @GetMapping("/")
    public RespBean getRoles() {

        return RespBean.getSuccess(null, permissService.getRoles());
    }

    @GetMapping("/menus")
    public RespBean getMenus() {
        return RespBean.getSuccess(null, permissService.getMenus());
    }

    @PostMapping("/")
    @SystemControllerLog(description = "添加角色操作")
    public RespBean addRole(@RequestBody Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (permissService.addRole(role) == 1) {
            return RespBean.getSuccess("添加角色成功！");
        }
        return RespBean.getSuccess("添加角色失败！");
    }

    @GetMapping("/getMenuId/{rid}")
    public RespBean getMenuIdByrid(@PathVariable Integer rid) {
        return RespBean.getSuccess(null, permissService.getMenuIdByrid(rid));
    }

    @PutMapping("/")
    @SystemControllerLog(description = "修改角色操作")
    public RespBean updateMenuWithRole(Integer rid, Integer[] mids) {
        if (permissService.insertMenuWithRole(rid, mids)) {
            return RespBean.getSuccess("更新成功！");
        }
        return RespBean.getError("更新失败！");
    }

    @DeleteMapping("/{rid}")
    @SystemControllerLog(description = "删除角色操作")
    public RespBean deleteById(@PathVariable Integer rid) {
        if (permissService.deleteById(rid) == 1) {
            return RespBean.getSuccess("删除成功！");
        }
        return RespBean.getError("删除失败！");
    }
}