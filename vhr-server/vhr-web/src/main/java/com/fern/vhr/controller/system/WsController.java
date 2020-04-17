/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: WsController
 * Author:   Administrator
 * Date:     2020/3/20 7:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system;

import com.fern.vhr.model.ChatMessage;
import com.fern.vhr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * 〈用户向客户端广播消息〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handle(Authentication authentication, ChatMessage chatMessage) {
        Hr hr = ((Hr) authentication.getPrincipal());
        chatMessage.setName(hr.getName());
        chatMessage.setFrom(hr.getUsername());
        chatMessage.setDate(new Date());
        //第二个参数是监听这个URL的请求
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getTo(), "/queue/chat", chatMessage);

    }
}