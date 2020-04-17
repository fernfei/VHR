/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SalaryConfigController
 * Author:   Administrator
 * Date:     2020/3/22 6:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.salary;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.SalarySobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/22
 * @since 1.0.0
 */
@RestController
@RequestMapping("/salary/sobcfg/")
public class SalaryConfigController {
    @Autowired
    private SalarySobService salarySobService;

    @GetMapping("/")
    public RespBean getAllSobConfigs(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return RespBean.getSuccess(null, salarySobService.getAllSobConfigs(page, size));
    }

    @GetMapping("/salary")
    public RespBean getAllSalary() {
        return RespBean.getSuccess(null, salarySobService.getAllSalarySobs());
    }

    @PutMapping("/updateSalarySob")
    @SystemControllerLog(description = "修改员工薪资操作")
    public RespBean updateSalarySob(String employeeId, String salaryId) {
        if (salarySobService.updateSalarySob(Integer.parseInt(employeeId), Integer.parseInt(salaryId))!=0) {
            return RespBean.getSuccess("修改成功！");
        }
        return RespBean.getSuccess("修改失败！");
    }


}