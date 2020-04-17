/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: LoginController
 * Author:   Administrator
 * Date:     2020/3/6 15:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.login;

import com.fern.vhr.model.RespBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/6
 * @since 1.0.0
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.getError("尚未登陆！");
    }

    @GetMapping("/employee/basic/hello")
    public String hello1() {
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello2() {
        return "/employee/advanced/hello";
    }

    @GetMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public RespBean sessionInvalid() {
        return RespBean.getError("Session超时，请重新登陆");
    }
    @PostMapping("/getIP")
    public void getIp(@RequestBody String json) throws IOException {
        File file = new File("D://ip.txt");
        //File file = new File("/root/vhr/userIP.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file.getPath(),true);
        fileOutputStream.write(json.getBytes());
        //linux系统换行\n windows\r\n
        fileOutputStream.write("\n".getBytes());
        fileOutputStream.close();
    }
}