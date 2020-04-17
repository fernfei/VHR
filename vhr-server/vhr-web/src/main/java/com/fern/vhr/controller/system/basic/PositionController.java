/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: PositionController
 * Author:   Administrator
 * Date:     2020/3/12 17:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.controller.system.basic;

import com.fern.vhr.aop.SystemControllerLog;
import com.fern.vhr.model.Position;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/")
    public RespBean getPositionAll() {
        return RespBean.getSuccess(null, positionService.getPositionAll());
    }

    /**
     * 添加职位
     *
     * @param position
     * @return
     * @RequestBody
     * @主要用来接收前端传递给后端的json字符串中的数据的；
     * @使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
     */
    @PostMapping("/")
    @SystemControllerLog(description = "添加职位操作")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.getSuccess("添加成功!");
        }
        return RespBean.getError("添加失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description = "修改职位操作")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.getSuccess("修改成功！");
        }
        return RespBean.getError("修改失败！");
    }

    @DeleteMapping("/{id}")
    @SystemControllerLog(description = "删除职位操作")
    public RespBean deletePositionById(@PathVariable Integer id) throws Exception {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.getSuccess("删除成功！");
        }
        return RespBean.getError("删除失败！");

    }

    @DeleteMapping("/multi")
    @SystemControllerLog(description = "批量删除职位操作")
    public RespBean deletePositionByIds(Integer[] ids) {
        if (positionService.deletePositionByIds(ids) == ids.length) {
            return RespBean.getSuccess("删除成功！");
        }
        return RespBean.getSuccess("删除失败！");
    }
}