/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SystemLog
 * Author:   Administrator
 * Date:     2020/3/28 6:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system;

import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.HrService;
import com.fern.vhr.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈操作系统的日志〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/log")
public class SystemLogController {
    @Autowired
    private SystemLogService systemLogService;
    @Autowired
    private HrService hrService;
    @GetMapping("/")
    public RespBean getSystemLogs(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords) {
        Integer hrid = 0;
        if (keywords != null && keywords != "") {
            hrid =hrService.getIdByName(keywords);
        }
        if (hrid == null) {
            return RespBean.getError("用户名不存在！");
        }
        return RespBean.getSuccess(null, systemLogService.getSystemLogs(page, size, hrid));
    }
}