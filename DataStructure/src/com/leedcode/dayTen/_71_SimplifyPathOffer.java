package com.leedcode.dayTen;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/4/10-12:16 下午
 */
public class _71_SimplifyPathOffer {


    public static void main(String[] args) {


        String str="/home/";

        System.out.println(simplifyPath(str));

    }

    /**
     * 使用栈进行解决
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {

        //1.将字符串按早/进行分割
        String[] split = path.split("/");
        //2.创建一个栈用来存储关键信息
        ArrayDeque<String> stack=new ArrayDeque<>();
        //对字符串进行遍历
        for(String str:split){
            if (str.equals("..")&&!stack.isEmpty()){//则进行执行出栈操作
                stack.pop();
            }
            if (!str.equals(".")&&!str.equals("")&&!str.equals("..")){//执行入栈操作
                stack.push(str);
            }
        }
        if (stack.isEmpty()) return "/";//如果栈为空说明没元素  之间返回即可
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append("/");
            //先拿栈底的元素
            String s = stack.removeLast();
            sb.append(s);
        }


        return sb.toString();



    }

}
