/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: POIUtils
 * Author:   Administrator
 * Date:     2020/3/18 20:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.utils;

import com.fern.vhr.model.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/18
 * @since 1.0.0
 */
public class POIUtils {

    /***
     * 员工数据集合转换成Excel
     * @param list
     * @return
     */
    public static ResponseEntity<byte[]> employeeToExcel(List<Employee> list) {
        for (Employee employee : list) {
            System.out.println(employee);
        }
        //1.创建一个excel文档
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //2.创建excel文档基本属性
        hssfWorkbook.createInformationProperties();
        //3.获取对象并配置文档摘要信息
        DocumentSummaryInformation docInfo = hssfWorkbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工信息");
        //文档管理员
        docInfo.setManager("fernFfy");
        //设置公司信息
        docInfo.setCompany("xxx公司");
        //4.获取对象并配置文档摘要信息  与上面的对象各司其职，都是配置摘要信息
        SummaryInformation summInfo = hssfWorkbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("员工信息表");
        //文档作者
        summInfo.setAuthor("fernFfy");
        //文档备注
        summInfo.setComments("本文档由fernFfy提供");

        //5.创建样式
        //创建标题行的样式
        HSSFCellStyle headStyle=hssfWorkbook.createCellStyle();
        headStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = hssfWorkbook.createCellStyle();
        //转换excel的日期格式
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        //在Excel里面创建一个表单
        HSSFSheet sheet = hssfWorkbook.createSheet("员工信息表");
        //设置每列的宽度，以字符宽度的1/256为单位的宽度 Excel中最大列宽为255个字符即255*256
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 5 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 14 * 256);
        sheet.setColumnWidth(15, 12 * 256);
        sheet.setColumnWidth(16,  8* 256);
        sheet.setColumnWidth(17, 20 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 12 * 256);
        sheet.setColumnWidth(20, 8 * 256);
        sheet.setColumnWidth(21, 25 * 256);
        sheet.setColumnWidth(22, 20 * 256);
        sheet.setColumnWidth(23, 20 * 256);
        //6.创建标题行
        HSSFRow r0 = sheet.createRow(0);
        //创建标题列(也就是单元格）
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellValue("姓名");
        c1 .setCellStyle(headStyle);
        HSSFCell c2 = r0.createCell(2);
        c2.setCellValue("性别");
        c2 .setCellStyle(headStyle);
        HSSFCell c3 = r0.createCell(3);
        c3.setCellValue("生日");
        c3 .setCellStyle(headStyle);
        HSSFCell c4 = r0.createCell(4);
        c4.setCellValue("婚姻状况");
        c4 .setCellStyle(headStyle);
        HSSFCell c5 = r0.createCell(5);
        c5.setCellValue("汉族");
        c5 .setCellStyle(headStyle);
        HSSFCell c6 = r0.createCell(6);
        c6.setCellValue("籍贯");
        c6 .setCellStyle(headStyle);
        HSSFCell c7 = r0.createCell(7);
        c7.setCellValue("政治面貌");
        c7 .setCellStyle(headStyle);
        HSSFCell c8 = r0.createCell(8);
        c8.setCellValue("邮箱");
        c8 .setCellStyle(headStyle);
        HSSFCell c9 = r0.createCell(9);
        c9.setCellValue("手机号码");
        c9 .setCellStyle(headStyle);
        HSSFCell c10 = r0.createCell(10);
        c10.setCellValue("居住地址");
        c10.setCellStyle(headStyle);
        HSSFCell c11 = r0.createCell(11);
        c11.setCellValue("部门");
        c11.setCellStyle(headStyle);
        HSSFCell c12 = r0.createCell(12);
        c12.setCellValue("职称");
        c12.setCellStyle(headStyle);
        HSSFCell c13 = r0.createCell(13);
        c13.setCellValue("职位");
        c13.setCellStyle(headStyle);
        HSSFCell c14 = r0.createCell(14);
        c14.setCellValue("聘用形式");
        c14.setCellStyle(headStyle);
        HSSFCell c15 = r0.createCell(15);
        c15.setCellValue("最高学历");
        c15.setCellStyle(headStyle);
        HSSFCell c16 = r0.createCell(16);
        c16.setCellValue("专业");
        c16.setCellStyle(headStyle);
        HSSFCell c17 = r0.createCell(17);
        c17.setCellValue("毕业院校");
        c17.setCellStyle(headStyle);
        HSSFCell c18 = r0.createCell(18);
        c18.setCellValue("入职日期");
        c18.setCellStyle(headStyle);
        HSSFCell c19 = r0.createCell(19);
        c19.setCellValue("工作状态");
        c19.setCellStyle(headStyle);
        HSSFCell c20 = r0.createCell(20);
        c20.setCellValue("工号");
        c20.setCellStyle(headStyle);
        HSSFCell c21 = r0.createCell(21);
        c21.setCellValue("合同期限");
        c21.setCellStyle(headStyle);
        HSSFCell c22 = r0.createCell(22);
        c22.setCellValue("转正日期");
        c22.setCellStyle(headStyle);
        HSSFCell c23 = r0.createCell(23);
        c23.setCellValue("合同起始时间");
        c23.setCellStyle(headStyle);
        HSSFCell c24 = r0.createCell(24);
        c24.setCellValue("合同结束时间");
        c24.setCellStyle(headStyle);


        //将员工信息存入excel里
        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            //第一行是标题行，因此不放数据
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getGender());
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellStyle(dateCellStyle);
            cell3.setCellValue(emp.getBirthday());
            row.createCell(4).setCellValue(emp.getWedlock());
            row.createCell(5).setCellValue(emp.getNation().getName());
            row.createCell(6).setCellValue(emp.getNativeplace());
            row.createCell(7).setCellValue(emp.getPoliticsstatus().getName());
            row.createCell(8).setCellValue(emp.getEmail());
            row.createCell(9).setCellValue(emp.getPhone());
            row.createCell(10).setCellValue(emp.getAddress());
            row.createCell(11).setCellValue(emp.getDepartment().getName());
            row.createCell(12).setCellValue(emp.getJobLevel().getName());
            row.createCell(13).setCellValue(emp.getPosition().getName());
            row.createCell(14).setCellValue(emp.getEngageform());
            row.createCell(15).setCellValue(emp.getTiptopdegree());
            row.createCell(16).setCellValue(emp.getSpecialty());
            row.createCell(17).setCellValue(emp.getSchool());
            HSSFCell cell18 = row.createCell(18);
            cell18.setCellStyle(dateCellStyle);
            cell18.setCellValue(emp.getBegindate());
            row.createCell(19).setCellValue(emp.getWorkstate());
            row.createCell(20).setCellValue(emp.getWorkid());
            if (emp.getContractterm() != null) {
                row.createCell(21).setCellValue(emp.getContractterm());
            }else{
                row.createCell(21).setCellValue("");

            }
            HSSFCell cell22 = row.createCell(22);
            cell22.setCellStyle(dateCellStyle);
            cell22.setCellValue(emp.getConversiontime());
            HSSFCell cell23 = row.createCell(23);
            cell23.setCellStyle(dateCellStyle);
            cell23.setCellValue(emp.getBegincontract());
            HSSFCell cell24 = row.createCell(24);
            cell24.setCellStyle(dateCellStyle);
            cell24.setCellValue(emp.getEndcontract());

        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工信息表.xls"
                    .getBytes("UTF-8"), "ISO-8859-1"));
            //设置响应头
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            hssfWorkbook.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //HttpStatus.CREATED 请求已经被服务器处理了，并且已经产生了一个新的资源。
        return new ResponseEntity<byte[]>(bytes.toByteArray(), headers, HttpStatus.CREATED);

    }

    /***
     * Excel转换成员工数据集合
     * @param file
     * @param allNation
     * @param politicsStatus
     * @param departments
     * @param positionAll
     * @param jobLevelAll
     * @return
     */
    public static List<Employee> ExcelToEmployee(MultipartFile file, List<Nation> allNation, List<Politicsstatus> politicsStatus, List<Department> departments, List<Position> positionAll, List<JobLevel> jobLevelAll) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = null;
        try {
            //1.获取一个Excel对象并将文件对象以输入流的方式传入
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2.获取workbook中的表单数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3.获取每个表单
                HSSFSheet sheetAt = workbook.getSheetAt((i));
                //4.获取总行数
                int rows = sheetAt.getPhysicalNumberOfRows();
                for (int j = 0; j < rows; j++) {
                    //5.说明是第一行，标题行不用解析
                    if (j == 0) {
                        continue;
                    }
                    //6.获取每一行
                    HSSFRow row = sheetAt.getRow(j);
                    if (row == null) {
                        //防止有空行出现
                        continue;
                    }
                    //获取总列数
                    int cells = row.getPhysicalNumberOfCells();
                    employee = new Employee();
                    for (int k = 0; k < cells; k++) {
                        //获取每一列
                        HSSFCell cell = row.getCell(k);
                        //因为每列的数据类型有可能是String，Date类型因此要分开处理
                        switch (cell.getCellTypeEnum()) {
                            //处理String类型的
                            case STRING:
                                String stringCellValue = cell.getStringCellValue();
                                switch (k) {
                                    //第0列的id是自增长的因此不需要管它
                                    case 1:
                                        employee.setName(stringCellValue);
                                        break;
                                    case 2:
                                        employee.setGender(stringCellValue);
                                        break;
                                    case 4:
                                        employee.setWedlock(stringCellValue);
                                        break;
                                    case 5:
                                        /***
                                         * indexOf(Object)
                                         * 通过对象的hashcode与allNation集合中的对象进行比较是否相等
                                         * 相等才返回集合对象的索引位置
                                         *
                                         * 但问题是我们从excel中的数据是不可能知道他在数据库中的ID的
                                         * 因此我们需要重写Nation类hash
                                         * 让其只比较name相等就算是一个对象
                                         */
                                        int nationIndex = allNation.indexOf(new Nation(stringCellValue));
                                        employee.setNationid(allNation.get(nationIndex).getId());
                                        break;
                                    case 6:
                                        employee.setNativeplace(stringCellValue);
                                        break;
                                    case 7:
                                        int politiIndex = politicsStatus.indexOf(new Politicsstatus(stringCellValue));
                                        employee.setPoliticid(politicsStatus.get(politiIndex).getId());
                                        break;
                                    case 8:
                                        employee.setEmail(stringCellValue);
                                        break;
                                    case 9:
                                        employee.setPhone(stringCellValue);
                                        break;
                                    case 10:
                                        employee.setAddress(stringCellValue);
                                        break;
                                    case 11:
                                        int depIndex = departments.indexOf(new Department(stringCellValue));
                                        employee.setDepartmentid(departments.get(depIndex).getId());
                                        break;
                                    case 12:
                                        int jobIndex = jobLevelAll.indexOf(new JobLevel(stringCellValue));
                                        employee.setJoblevelid(jobLevelAll.get(jobIndex).getId());
                                        break;
                                    case 13:
                                        int posIndex = positionAll.indexOf(new Position(stringCellValue));
                                        employee.setPosid(positionAll.get(posIndex).getId());
                                        break;
                                    case 14:
                                        employee.setEngageform(stringCellValue);
                                        break;
                                    case 15:
                                        employee.setTiptopdegree(stringCellValue);
                                        break;
                                    case 16:
                                        employee.setSpecialty(stringCellValue);
                                        break;
                                    case 17:
                                        employee.setSchool(stringCellValue);
                                        break;
                                    case 19:
                                        employee.setWorkstate(stringCellValue);
                                        break;
                                    case 20:
                                        employee.setWorkid(stringCellValue);
                                        break;

                                }
                                break;
                            default:{
                                //类型不是String就来这里
                                switch (k) {
                                    case 3:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 18:
                                        employee.setBegindate(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        employee.setConversiontime(cell.getDateCellValue());
                                        break;
                                    case 23:
                                        employee.setBegincontract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        employee.setEndcontract(cell.getDateCellValue());
                                        break;
                                }
                                break;
                            }
                        }

                    }
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}