/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HrUtils
 * Author:   Administrator
 * Date:     2020/3/15 22:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.utils;



import com.fern.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 〈用户返回当前用户的工具类〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/15
 * @since 1.0.0
 */
public class HrUtils {
    public static Hr getHr() {
        //SpringSecurity的上下文获取当前用户对象
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}