/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: GlobalHandleException
 * Author:   Administrator
 * Date:     2020/3/12 23:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.exception;

import com.fern.vhr.model.RespBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 〈本系统的全局异常处理〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/12
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalHandleException {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandleException.class);
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        LOGGER.info("数据库操作异常信息：" + e.getMessage());
        /*操作数据库发生外键时触发的异常*/
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.getError("该数据与其他数据有关联，操作失败！");
        } else if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.getError("添加的数据重复！");
        }

        return RespBean.getError("数据库操作异常，操作失败！");
    }
}