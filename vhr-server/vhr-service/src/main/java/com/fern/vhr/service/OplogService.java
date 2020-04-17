/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: OplogService
 * Author:   Administrator
 * Date:     2020/3/28 6:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.OpLogMapper;
import com.fern.vhr.model.OpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/28
 * @since 1.0.0
 */
@Service
public class OplogService {
    @Autowired
    private OpLogMapper opLogMapper;
    //操作日志
    public Integer addOpLog(OpLog opLog) {
        return opLogMapper.insert(opLog);
    }
}