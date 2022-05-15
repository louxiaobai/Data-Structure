package com.utils;

import java.util.UUID;

/**
 * @author lqw
 * @date 2021/10/9-8:30 обнГ
 */
public class IDUtils {


    public static String getId(){


        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }



}