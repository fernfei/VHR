package com.fern.vhr.mapper;

import com.fern.vhr.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getDepartments(@Param("id") int i);

    void addDepartment(Department department);

    void deleteDepartment(Department department);

    List<Department> getAllDepartments();

}