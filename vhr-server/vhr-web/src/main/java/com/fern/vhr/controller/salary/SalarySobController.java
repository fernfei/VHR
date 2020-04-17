/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SalaryController
 * Author:   Administrator
 * Date:     2020/3/21 22:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.salary;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.model.Salary;
import com.fern.vhr.service.SalarySobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/salary/sob")
public class SalarySobController {

    @Autowired
    private SalarySobService salarySobService;

    @GetMapping("/")
    public RespBean getAllSalarySobs() {
        return RespBean.getSuccess(null, salarySobService.getAllSalarySobs());
    }

    @PutMapping("/")
    @SystemControllerLog(description = "修改部门薪资操作")
    public RespBean updateSob(@RequestBody Salary salary) {
        if (salarySobService.updateSob(salary) == 1) {
            return RespBean.getSuccess("修改成功！");
        }
        return RespBean.getError("修改失败！");
    }

    @PostMapping("/")
    @SystemControllerLog(description = "添加部门薪资操作")
    public RespBean addSob(@RequestBody Salary salary) {
        if (salarySobService.addSob(salary) == 1) {
            return RespBean.getSuccess("添加成功！");
        }
        return RespBean.getError("添加失败!");
    }

    @DeleteMapping("/{id}")
    @SystemControllerLog(description = "删除部门薪资操作")
    public RespBean deleteSob(@PathVariable Integer id) {
        if (salarySobService.deleteSob(id) == 1) {
            return RespBean.getSuccess("删除成功！");
        }
        return RespBean.getSuccess("删除失败！");
    }

    /***
     * 文件下载
     * @return
     */
    @GetMapping("/download")
    @SystemControllerLog(description = "下载系统源码操作")
    public ResponseEntity<FileSystemResource> downloadFile() {
        try {
            File file = new File("/root/vhr/vhr.rar");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Last-Modified", new Date().toString());
            headers.add("ETag", String.valueOf(System.currentTimeMillis()));
            return  ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            e.printStackTrace();

        }
        return org.springframework.http.ResponseEntity.status(Integer.parseInt("203")).build();

    }
}