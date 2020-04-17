/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SystemLogService
 * Author:   Administrator
 * Date:     2020/3/28 6:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.HrMapper;
import com.fern.vhr.mapper.OpLogMapper;
import com.fern.vhr.model.Hr;
import com.fern.vhr.model.OpLog;
import com.fern.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/28
 * @since 1.0.0
 */
@Service
public class SystemLogService {
    @Autowired
    private OpLogMapper opLogMapper;
    public RespPageBean getSystemLogs(Integer page, Integer size, Integer  hrid) {
        if (page != null) {
            page = (page - 1) * 10;
        }


        int total= opLogMapper.getTotal();
        List<OpLog> list = opLogMapper.getSystemLogs(page, size, hrid);
        return new RespPageBean(total, list);
    }
}