/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: DepartmentController
 * Author:   Administrator
 * Date:     2020/3/15 0:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system.basic;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.Department;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/15
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public RespBean getDepartments() {
        return RespBean.getSuccess(null,departmentService.getDepartments(-1));
    }

    @PostMapping("/")
    @SystemControllerLog(description = "添加部门操作")
    public RespBean addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        if (department.getResult() == 1) {
            department.setId(department.getResult2());
            return RespBean.getSuccess("添加成功！",department);
        }
        return RespBean.getError("添加失败！");
    }

    @DeleteMapping("/{id}")
    @SystemControllerLog(description = "删除部门操作")
    public RespBean deleteDepartment(@PathVariable Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDepartment(department);
        if (department.getResult() == -1) {
            return RespBean.getError("该部门下有员工无法删除！");
        } else if (department.getResult() == -2) {
            return RespBean.getError("该部门下有子部门无法删除！");
        } else if (department.getResult() == 1) {
            return RespBean.getSuccess("删除成功！", department);
        }else{
            return RespBean.getError("删除失败！");
        }
    }
}