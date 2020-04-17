/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChatService
 * Author:   Administrator
 * Date:     2020/3/20 6:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.HrMapper;
import com.fern.vhr.model.Hr;
import com.fern.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
@Service
public class ChatService {
    @Autowired
    private HrMapper hrMapper;
    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getHr().getId());
    }
}