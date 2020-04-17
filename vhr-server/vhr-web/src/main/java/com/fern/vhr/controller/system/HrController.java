/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HrController
 * Author:   Administrator
 * Date:     2020/3/15 22:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.mapper.HrMapper;
import com.fern.vhr.model.Hr;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.HrService;
import com.fern.vhr.utils.HrUtils;
import com.fern.vhr.utils.QiniuCloudUtil;
import com.qiniu.common.QiniuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/15
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    private HrService hrService;

    @GetMapping("/")
    public RespBean getAllHr(String keywords) {
        return RespBean.getSuccess(null, hrService.getAllHr(keywords));
    }

    @PostMapping("/")
    @SystemControllerLog(description = "禁用或开启用户操作")
    public RespBean updateEnabled(@RequestBody Hr hr) {
        if (hrService.updateEnabled(hr) == 1) {
            return RespBean.getSuccess("更新成功！");
        }
        return RespBean.getError("更新失败！");
    }

    @DeleteMapping("/")
    @SystemControllerLog(description = "删除用户角色操作")
    public RespBean deleteHrRolesById(Integer hrid, Integer rid) {
        if (hrService.deleteRolesById(hrid, rid) == 1) {
            return RespBean.getSuccess("删除角色成功！");
        }
        return RespBean.getError("删除角色失败！");
    }

    @PutMapping("/")
    @SystemControllerLog(description = "修改用户角色操作")
    public RespBean updateHrRoles(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRoles(hrid, rids)) {
            return RespBean.getSuccess("修改角色成功！");
        }
        return RespBean.getError("修改角色失败！");
    }

    @DeleteMapping("/{id}")
    @SystemControllerLog(description = "删除用户操作")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.getSuccess("删除成功！");
        }
        return RespBean.getError("删除失败！");
    }

    @PostMapping("/upload")
    @SystemControllerLog(description = "上传头像操作")
    public RespBean uploadImage(MultipartFile file) {
        //windows
        String windowsPath = "D:\\upload\\images\\";
        //String linuxPath = "/root/vhr/images/";
        File f = new File(windowsPath);
        if (!f.exists()) {
            f.mkdirs();
        }
        File localFile = new File(windowsPath + file.getOriginalFilename());
        String url = null;
        try {
            file.transferTo(localFile);
            url = QiniuCloudUtil.upload(localFile.getPath());
            System.out.println("URL:" + url);
            if (url != null) {
                Hr hr = HrUtils.getHr();
                hr.setUserface(url);
                int i = hrService.updateHr(hr);
                if (i != 1) {
                    return RespBean.getError("上传头像失败！");
                }
            }
        } catch (QiniuException e) {
            e.printStackTrace();
            return RespBean.getError("图片上传异常：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return RespBean.getError("IO操作异常：" + e.getMessage());
        }
        return RespBean.getSuccess(null, url);
    }

    @PostMapping("/updateHr")
    @SystemControllerLog(description = "修改密码操作")
    public RespBean updateHr(@RequestBody Hr hr) {
        //加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        hr.setPassword(bCryptPasswordEncoder.encode(hr.getPassword()));
        if (hrService.updateHr(hr) == 1) {
            return RespBean.getSuccess("修改成功！");
        }
        return RespBean.getError("修改成功！");
    }
}