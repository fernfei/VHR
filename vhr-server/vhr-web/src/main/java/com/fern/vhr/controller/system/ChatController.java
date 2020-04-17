/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChatController
 * Author:   Administrator
 * Date:     2020/3/20 6:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system;

import com.fern.vhr.model.Hr;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈用于返回用户列表〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @GetMapping("/chat")
    public RespBean getAllHrsExceptCurrentHr() {
        return RespBean.getSuccess(null, chatService.getAllHrsExceptCurrentHr());
    }
}