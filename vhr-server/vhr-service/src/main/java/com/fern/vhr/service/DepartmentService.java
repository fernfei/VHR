/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: DepartmentService
 * Author:   Administrator
 * Date:     2020/3/15 0:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.DepartmentMapper;
import com.fern.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/15
 * @since 1.0.0
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public List<Department> getDepartments(int i) {
        return departmentMapper.getDepartments(i);
    }
    public void addDepartment(Department department) {
        department.setEnabled(true);
        departmentMapper.addDepartment(department);
        
    }

    public void deleteDepartment(Department department) {
        departmentMapper.deleteDepartment(department);
    }

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

}





