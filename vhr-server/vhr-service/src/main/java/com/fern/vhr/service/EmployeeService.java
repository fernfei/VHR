/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: EmployeeService
 * Author:   Administrator
 * Date:     2020/3/16 22:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.service;

import com.fern.vhr.mapper.EmployeeMapper;
import com.fern.vhr.mapper.NationMapper;
import com.fern.vhr.mapper.PoliticsstatusMapper;
import com.fern.vhr.model.Employee;
import com.fern.vhr.model.Nation;
import com.fern.vhr.model.Politicsstatus;
import com.fern.vhr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/16
 * @since 1.0.0
 */
@Service
public class EmployeeService {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private NationMapper nationMapper;
    @Autowired
    private PoliticsstatusMapper politicsstatusMapper;
    private SimpleDateFormat year = new SimpleDateFormat("yyyy");
    private SimpleDateFormat month = new SimpleDateFormat("MM");
    //https://www.jianshu.com/p/b3699d73142e具体使用请访问该文档
    //#代表一个阿拉伯数字  ##代表两个阿拉伯数字
    //.代表小数符号
    //00保留小数两位
    private DecimalFormat decimalFormat = new DecimalFormat("##.00");
    public RespPageBean getEmployee(Integer page, Integer size,String keywords) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        Integer total = employeeMapper.getTotal(keywords);
        List<Employee> employee = employeeMapper.getEmployee(page, size,keywords);
        return new RespPageBean(total, employee);
    }

    public Integer addEmployee(Employee employee) {
        Date begincontract = employee.getBegincontract();
        Date endcontract = employee.getEndcontract();
        //结束合同时间-起始合同时间=合同期限
        //先将日期年转换成数字，再将月份转换成数字
        //结束年份-开始年份=总年份
        // 例如  2023年3月-2019年6月  2023-2019其实等于2023年6月-2019年6月
        Double result = (Double.parseDouble(year.format(endcontract)) - Double.parseDouble(year.format(begincontract))) * 12 +
                (Double.parseDouble(month.format(endcontract)) - Double.parseDouble(month.format(begincontract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(result / 12)));
        Integer success = employeeMapper.insertSelective(employee);
        if (success==1) {
            Employee emp= employeeMapper.getEmployeeById(employee.getId());
            LOGGER.info(emp.toString());
            //发送消息到消息中间件
            rabbitTemplate.convertAndSend("fern.mail.welcome", emp);
        }
        return success;
    }

    public List<Nation> getAllNation() {
        return nationMapper.getAllNation();
    }

    public List<Politicsstatus> getPoliticsStatus() {
        return politicsstatusMapper.getPoliticsStatus();
    }

    public Integer getWorkId() {
        return employeeMapper.getWorkId();
    }

    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmployees(List<Employee> list) {
        return employeeMapper.addEmployees(list);
    }

    public RespPageBean advancedSearch( Integer page, Integer size,Employee employee, String beginDate, String endDate) throws ParseException {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        Date beginDate1 = null;
        Date endDate1 = null;
        if (beginDate != null && beginDate != "") {
            beginDate1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(beginDate);
        }
        if (endDate != null && endDate != "") {
            endDate1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(endDate);
        }

        int total = employeeMapper.getTotalWithAdvancedSearch(employee,beginDate1,endDate1);
        List<Employee> list = employeeMapper.advancedSearch(page,size, employee, beginDate1, endDate1);
        return new RespPageBean(total, list);
    }

    public Integer deleteEmployeeById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteEmployeeByIdByIds(Integer[] ids) {
        if (ids != null && ids.length != 0) {
            return employeeMapper.deleteEmployeeByIdByIds(ids);

        }
        return 0;
    }
}