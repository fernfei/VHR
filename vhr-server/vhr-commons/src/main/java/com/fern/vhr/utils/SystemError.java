/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SystemError
 * Author:   Administrator
 * Date:     2020/3/6 14:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.utils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/6
 * @since 1.0.0
 */
public class SystemError extends RuntimeException {
    /**
     * 错误码
     */
    private ErrorCodeEnum errorCodeEnum;

    /***
     * 根据用户输入的异常描述显示
     * @param errorCodeEnum 异常枚举
     * @param message 异常描述
     * @throws Exception
     */
    public SystemError(ErrorCodeEnum errorCodeEnum,String message) throws Exception {
        super(message==null?errorCodeEnum.getMsg():message);
        if (errorCodeEnum == null) {
            throw new Exception("必须传入异常信息");
        }
        this.errorCodeEnum = errorCodeEnum;
    }

    /**
     * 使用系统默认的异常信息描述
     * @param errorCodeEnum
     */
    public SystemError(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }
}