package com.leedcode.dayFive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2022/3/6-9:41 下午
 */
public class _1_PlusOne {

    /**
     * 思路:1.从后往前进行加一操作,如果不满足 10则直接返回 加一后的原数组如果满足10则进行持续进位,新学到java中另开辟数组空间的方法
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {//从后往前进行遍历

            digits[i]++;//进行加一操作

            if (digits[i]%10!=0) return digits;

            digits[i]=digits[i]%10;

        }
        digits=new int[digits.length+1];//进行扩容操作---并且第一位是为空的
        digits[0]=1;
        return digits;
    }
}