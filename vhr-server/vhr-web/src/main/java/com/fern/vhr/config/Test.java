/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Test
 * Author:   Administrator
 * Date:     2020/3/11 6:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/11
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
       /* //需要的角色
        List<String> list1 = new ArrayList<>();
        list1.add("ROLE_ADMIN");
        list1.add("ROLE_USER");
        list1.add("ROLE_PM");
        list1.add("ROLE_SM");
        //具备的角色
        List<String> list2 = new ArrayList<>();
        list2.add("ROLE_USER");
        list2.add("ROLE_HR");
        list2.add("ROLE_PM");
        list2.add("ROLE_SM");
        list2.add("ROLE_ADMIN");
        int flag = 0;
        for (String s2 : list2) {
            for (String s1 : list1) {
                if (s2.equals(s1)) {
                    flag++;

                }
            }
        }

        if (flag == list1.size()) {
            System.out.println("具备权限");
        }else{
            System.out.println("权限不足");
        }
        */
        ArrayList<Integer> integers1 = new ArrayList<>();
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers1.add(6);
        integers1.add(9);
        integers1.add(1);
        integers1.add(4);
        integers1.add(5);
        integers1.add(11);

        integers2.add(6);
        integers2.add(10);
        integers2.add(5);
        integers2.add(7);
        integers2.add(23);
        // 6  9  1  4  5
        // 6 10  5  7  23
        ArrayList<Integer> noRepeat = new ArrayList<>();
        for (Integer integer : integers1) {
            for (Integer integer1 : integers2) {
                if (integer == integer1) {
                    break;
                }
                if (integer != integer1) {
                    if (integer1 == integers2.get(integers2.size() - 1)) {
                        noRepeat.add(integer);
                    }
                }
            }
        }
        System.out.println(noRepeat);



    }

    public static  void findRepeat(Integer[]nums1,Integer[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        //Integer[] nums1 = {9, 3, 7, 23, 6};
        //Integer[] nums2 = {11, 12, 6, 2, 7};
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                //如果找出相等直接跳出本次循环
                if (nums1[i] == nums2[j]) {
                    break;
                }
                //如果找到不相等的也不要立马加存储起来了先看看是否循环完了
                if (nums1[i]!=nums2[j] &&j == nums2.length-1) {
                    hashSet.add(nums1[i]);
                }
            }
        }

        System.out.println(hashSet);
    }

}