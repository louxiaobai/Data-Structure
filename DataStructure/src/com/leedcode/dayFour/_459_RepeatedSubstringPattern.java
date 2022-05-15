package com.leedcode.dayFour;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author lqw
 * @date 2022/2/21-11:13 上午
 */
public class _459_RepeatedSubstringPattern {


    public static void main(String[] args) {

        String s="aabaaba";
        System.out.println(repeatedSubstringPattern(s));

    }

    /**
     *暴力解法:从头对字符串进行遍历操作长度的2倍要小于等于最大长度，双指针解法,从当前节点进行遍历对比字符是否相同,一直相等则为重复的字符串组成
     *时间复杂度:O(n^2)
     *空间复杂度:O(1)
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {

        int length=s.length();

        for (int len = 1; len*2<=length; len++) {

            if(length%len==0) {

                boolean flag = true;
                int index = 0;
                for (int i = len; i < length; i++, index++) {
                    if (s.charAt(index) != s.charAt(i)) {
                        flag = false;
                        break;//跳出循环
                    }
                }

                if (flag) return true;
            }

        }

        return false;
    }
}