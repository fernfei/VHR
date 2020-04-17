/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: JobLevelService
 * Author:   Administrator
 * Date:     2020/3/13 2:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.JobLevelMapper;
import com.fern.vhr.model.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/13
 * @since 1.0.0
 */
@Service
public class JobLevelService {
    @Autowired
    private JobLevelMapper jobLevelMapper;
    public List<JobLevel> getJobLevelAll() {
        return jobLevelMapper.getJobLevelAll();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        if (jobLevel.getName() == null || jobLevel.getTitlelevel() == null) {
            return 0;
        }
        jobLevel.setCreatedate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insert(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        jobLevel.setCreatedate(new Date());
        return jobLevelMapper.updateByPrimaryKey(jobLevel);
    }

    public Integer deleteJobLevel(Integer id) {

        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }

    public List<String> getTitleLevle() {
        return jobLevelMapper.getTitleLevle();
    }
}