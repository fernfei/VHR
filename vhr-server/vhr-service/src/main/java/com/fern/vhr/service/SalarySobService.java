/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SalaryService
 * Author:   Administrator
 * Date:     2020/3/21 22:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.EmpSalaryMapper;
import com.fern.vhr.mapper.SalaryMapper;
import com.fern.vhr.model.EmpSalary;
import com.fern.vhr.model.RespPageBean;
import com.fern.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/21
 * @since 1.0.0
 */
@Service
public class SalarySobService {
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private EmpSalaryMapper empSalaryMapper;
    public List<Salary> getAllSalarySobs() {

        return salaryMapper.getAllSalarySobs();
    }

    public Integer updateSob(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    public Integer addSob(Salary salary) {
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSob(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }


    public RespPageBean getAllSobConfigs(Integer page, Integer size) {
        page = (page - 1) * 10;
        Integer total = empSalaryMapper.getAllConfigCount();
        List<EmpSalary> list = empSalaryMapper.getAllSobConfigs(page, size);
        return new RespPageBean(total, list);
    }

    public Integer updateSalarySob(Integer employeeId, Integer salaryId) {
        Integer result= empSalaryMapper.isExits(employeeId);
        if (result != 0) {
            //修改
           return empSalaryMapper.updateSalarySob(employeeId, salaryId);
        }
        //添加
        return empSalaryMapper.insertSalarySob(employeeId, salaryId);
    }
}