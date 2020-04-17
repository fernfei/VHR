package com.fern.vhr.mapper;

import com.fern.vhr.model.EmpSalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);

    EmpSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpSalary record);

    int updateByPrimaryKey(EmpSalary record);

    List<EmpSalary> getAllSobConfigs(@Param("page")Integer page, @Param("size")Integer size);

    Integer getAllConfigCount();

    Integer isExits(@Param("employeeId") Integer employeeId);

    Integer updateSalarySob(@Param("employeeId") Integer employeeId,@Param("salaryId") Integer salaryId);

    Integer insertSalarySob(@Param("employeeId")Integer employeeId,@Param("salaryId") Integer salaryId);
}