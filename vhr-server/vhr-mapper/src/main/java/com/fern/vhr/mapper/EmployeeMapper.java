package com.fern.vhr.mapper;

import com.fern.vhr.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployee(@Param("page") Integer page, @Param("size") Integer size, @Param("keywords") String keywords);

    Integer getTotal(@Param("keywords") String keywords);

    Integer getWorkId();

    Integer addEmployees(@Param("list") List<Employee> list);

    List<Employee> advancedSearch(@Param("page") Integer page, @Param("size") Integer size, @Param("employee") Employee employee, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    Integer getTotalWithAdvancedSearch(@Param("employee") Employee employee, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    Employee getEmployeeById(Integer id);

    Integer deleteEmployeeByIdByIds(@Param("ids") Integer[] ids);
}