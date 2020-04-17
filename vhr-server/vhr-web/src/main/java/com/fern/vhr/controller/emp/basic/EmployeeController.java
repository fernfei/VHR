/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: EmployeeController
 * Author:   Administrator
 * Date:     2020/3/16 22:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.emp.basic;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.Employee;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.DepartmentService;
import com.fern.vhr.service.EmployeeService;
import com.fern.vhr.service.JobLevelService;
import com.fern.vhr.service.PositionService;
import com.fern.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/16
 * @since 1.0.0
 */
@RestController
@RequestMapping("/emp/basic/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/")
    public RespBean getEmployee(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords) {

        return RespBean.getSuccess(null, employeeService.getEmployee(page, size, keywords));
    }

    @PostMapping("/")
    @SystemControllerLog(description = "添加员工操作")
    public RespBean addEmployee(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee) == 1) {
            return RespBean.getSuccess("添加员工成功！");
        }
        return RespBean.getError("添加员工失败！");
    }

    @GetMapping("/nations")
    public RespBean getAllNation() {
        return RespBean.getSuccess(null, employeeService.getAllNation());
    }

    @GetMapping("/departments")
    public RespBean getAllDepartments() {
        return RespBean.getSuccess(null, departmentService.getDepartments(-1));
    }

    @GetMapping("/positions")
    public RespBean getAllPositions() {
        return RespBean.getSuccess(null, positionService.getPositionAll());
    }

    @GetMapping("/joblevels")
    public RespBean getJobLevel() {
        return RespBean.getSuccess(null, jobLevelService.getJobLevelAll());
    }

    @GetMapping("/politicsstatus")
    public RespBean getPoliticsStatus() {
        return RespBean.getSuccess(null, employeeService.getPoliticsStatus());
    }

    @GetMapping("/workid")
    public RespBean getWorkId() {
        //总长度是8不足补0
        return RespBean.getSuccess(null, String.format("%08d", employeeService.getWorkId() + 1));
    }

    @PutMapping("/")
    @SystemControllerLog(description = "修改员工信息操作")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee) == 1) {
            return RespBean.getSuccess("修改员工信息成功！");
        }
        return RespBean.getError("修改员工信息失败！");
    }

    /***
     * 导出Excel
     * @return 返回一个byte[]字节数组
     */
    @GetMapping("/export")
    @SystemControllerLog(description = "导出员工Excel信息操作")
    public ResponseEntity<byte[]> exportData() {
        //获取所有员工信息
        List<Employee> list = (List<Employee>) employeeService.getEmployee(null, null, null).getData();
        System.out.println(list);
        return POIUtils.employeeToExcel(list);
    }

    @PostMapping("/import")
    @SystemControllerLog(description = "导入员工Excel信息操作")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.ExcelToEmployee(file, employeeService.getAllNation(), employeeService.getPoliticsStatus(),
                departmentService.getAllDepartments(), positionService.getPositionAll(), jobLevelService.getJobLevelAll());
        for (Employee employee : list) {
            System.out.println(employee);

        }
        if (employeeService.addEmployees(list) == list.size()) {

            return RespBean.getSuccess("导入数据成功！");
        }
        return RespBean.getSuccess("导入数据失败！");

    }

    @GetMapping("/advancedSearch")
    public RespBean advancedSearch(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, String beginDate, String endDate) throws ParseException {
        return RespBean.getSuccess(null, employeeService.advancedSearch(page, size, employee, beginDate, endDate));
    }

    @DeleteMapping("/{id}")
    @SystemControllerLog(description = "删除员工信息操作")
    public RespBean deleteEmployeeById(@PathVariable Integer id) {
        if (employeeService.deleteEmployeeById(id) == 1) {
            return RespBean.getSuccess("删除员工成功！");
        }
        return RespBean.getError("删除员工失败！");
    }

    @DeleteMapping("/many")
    @SystemControllerLog(description = "批量删除员工信息操作")
    public RespBean deleteEmployeeByIdByIds(Integer[] ids) {
        if (employeeService.deleteEmployeeByIdByIds(ids) == ids.length) {
            return RespBean.getSuccess("批量删除成功！");
        }
        return RespBean.getError("批量删除失败！");
    }
}