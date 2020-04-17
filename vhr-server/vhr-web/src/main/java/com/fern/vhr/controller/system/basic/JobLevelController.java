/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: JobLevelController
 * Author:   Administrator
 * Date:     2020/3/13 2:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system.basic;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.JobLevel;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/")
    public RespBean getJobLevelAll() {
        return RespBean.getSuccess(null, jobLevelService.getJobLevelAll());
    }

    @GetMapping("/titlelevel")
    public RespBean getTitleLevel() {
        return RespBean.getSuccess(null, jobLevelService.getTitleLevle());
    }

    @PostMapping("/")
    @SystemControllerLog(description = "添加职称操作")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.getSuccess("添加成功！");
        }
        return RespBean.getError("添加失败");
    }

    @PutMapping("/")
    @SystemControllerLog(description = "修改职称操作")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.getSuccess("修改成功！");
        }
        return RespBean.getError("添加失败");
    }

    @DeleteMapping("/{id}")
    @SystemControllerLog(description = "删除职称操作")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return RespBean.getSuccess("删除成功！");
        }
        return RespBean.getError("添加失败！");
    }

    @DeleteMapping("/multi")
    @SystemControllerLog(description = "批量删除职称操作")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelByIds(ids) == ids.length) {
            return RespBean.getSuccess("批量删除成功！");
        }

        return RespBean.getError("批量删除失败！");
    }

}