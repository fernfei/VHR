/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SystemControllerLog
 * Author:   Administrator
 * Date:     2020/3/28 3:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.aop;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/28
 * @since 1.0.0
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})//作用方法和参数上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented//表明这个注解应该被 javadoc工具记录
public @interface SystemControllerLog {
    String description() default "";
}