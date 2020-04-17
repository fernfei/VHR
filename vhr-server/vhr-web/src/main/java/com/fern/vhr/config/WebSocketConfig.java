/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: WebScoketConfig
 * Author:   Administrator
 * Date:     2020/3/20 7:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //前端的连接点
        //setAllowedOrigins 设置允许的指定域来访问
        registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();//要求前端使用socket.js工具
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //消息代理的前置，如果前端发的消息是以queue为前缀，那么这个消息交给消息代理，再由消息代理广播给所有连接的客户端
        registry.enableSimpleBroker("/queue");
    }

}