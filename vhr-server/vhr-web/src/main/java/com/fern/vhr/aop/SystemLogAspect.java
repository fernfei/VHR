/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SystemLogAspect
 * Author:   Administrator
 * Date:     2020/3/28 4:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.aop;

import com.fern.vhr.model.Hr;
import com.fern.vhr.model.OpLog;
import com.fern.vhr.service.OplogService;
import com.fern.vhr.utils.HrUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/28
 * @since 1.0.0
 */
@Aspect
@Component
public class SystemLogAspect {
    @Autowired
    private OplogService oplogService;
    //controller 层切入点
    @Pointcut("@annotation(com.fern.vhr.aop.SystemControllerLog)")
    public void controllerAspect() {

    }

    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) {
        Hr hr = HrUtils.getHr();
        try {
            //*========控制台输出=========*//
            /*System.out.println("==============前置通知开始==============");
            System.out.println("请求方法" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            System.out.println("方法描述：" + getServiceMethodDescription(joinPoint));
            System.out.println("请求人："+hr.getUsername());*/
            OpLog opLog = new OpLog();
            opLog.setHrid(hr.getId());
            opLog.setAdddate(new Date());
            opLog.setOperate(getServiceMethodDescription(joinPoint));
            oplogService.addOpLog(opLog);
        }catch (Exception e){
            //记录本地异常日志
            System.out.println("添加操作日志异常!");
        }
    }

    /**
     * @Description  获取注解中对方法的描述信息 用于service层注解
     * @date 2020年3月28日 下午5:05
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint)throws Exception{
        //获取类的全限定名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        Object[] arguments = joinPoint.getArgs();
        //反射
        Class targetClass = Class.forName(targetName);
        //获取该类下的所有方法
        Method[] methods = targetClass.getMethods();
        String description = "";
        //遍历方法
        for (Method method:methods) {
            //找出当前操作方法
            if (method.getName().equals(methodName)) {
                //方法的参数
                Class[] clazzs = method.getParameterTypes();
                //找出的方法参数和当前的操作的方法参数一样，那么就找出了该方法
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}