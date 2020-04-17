/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: RespPageBean
 * Author:   Administrator
 * Date:     2020/3/16 22:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.model;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/16
 * @since 1.0.0
 */
public class RespPageBean {
    private int total;
    private List<?> data;

    public RespPageBean() {
    }

    public RespPageBean(int total, List<?> data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}