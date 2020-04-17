package com.fern.vhr.mapper;

import com.fern.vhr.model.JobLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getJobLevelAll();

    Integer deleteJobLevelByIds(@Param("ids") Integer[] ids);

    List<String> getTitleLevle();
}