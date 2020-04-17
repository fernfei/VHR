/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: RespBean
 * Author:   Administrator
 * Date:     2020/3/6 13:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.model;

/**
 * 〈响应数据的实体类〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/6
 * @since 1.0.0
 */

public class RespBean {
    private Integer status;
    private String msg;
    private Object object;

    public static RespBean getSuccess(String msg) {
        return new RespBean(200, msg, null);
    }
    public static RespBean getSuccess(String msg,Object object) {
        return new RespBean(200, msg, object);
    }

    public static RespBean getError(String msg) {
        return new RespBean(500, msg, null);
    }
    public static RespBean getError(String msg,Object object) {
        return new RespBean(500, msg, object);
    }
    public RespBean() {
    }

    public RespBean(Integer status, String msg, Object object) {
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}