/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MailReceiver
 * Author:   Administrator
 * Date:     2020/3/19 21:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.mailserver.receiver;

import com.fern.vhr.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/19
 * @since 1.0.0
 */
@Component
public class MailReceiver {
    public static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
//    JavaMailSender是SpringBoot自动化的一个发送邮件类
    private JavaMailSender mailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
//    TemplateEngine是Thymeleaf的模板操作类
    private TemplateEngine templateEngine;

    //监听指定的队列
    @RabbitListener(queues = "fern.mail.welcome")
    public void handler(Employee employee) {
        logger.info(employee.toString());
        //收到消息，发送邮件
        //多用途邮件扩展
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            //发给谁
            helper.setTo(employee.getEmail());
            //来自谁
            helper.setFrom(mailProperties.getUsername());
            //主题
            helper.setSubject("入职欢迎邮件");
            //发送时间
            helper.setSentDate(new Date());
            //渲染邮件模板
            //操作html的类
            Context context = new Context();
            context.setVariable("name", employee.getName());
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("jobLevelName", employee.getJobLevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            //将html转成字符串发到邮箱
            String mailHtml = templateEngine.process("mail", context);
            //true开启html
            helper.setText(mailHtml,true);
            helper.setFrom("hufei1639670695@163.com");
            helper.setSentDate(new Date());
            helper.setTo("hufei1639670695@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("邮件发送失败：" + e.getMessage());
        }

    }
}