package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/6-10:52 上午
 */
public class _7_Reverse {

    public static void main(String[] args) {




        System.out.println(reverse(121));

    }


    /**
     * 假设环境不允许存储 64 位整数（有符号或无符号）意思就是不能使用long类型
     *思路:进行从后往前去出x的个位数-进行计算出sum的值,可以先计算出总数在进行判断溢出
     * 时间复杂度:0(1)
     * 空间复杂度:O(1)
     * @param x
     * @return
     */
    public static int reverse(int x) {

        if (x==0) return 0;

        int sum=0;
        while (x!=0){

             int pop=x%10;//取到数字的个位数

             x=x/10;//去掉最后一位个位数字

             int res=sum*10+pop;

             if ((res-pop)/10!=sum) return 0;//用于判断数字是否出现溢出--如果不相等则说明溢出了

             sum=res;

        }

        return sum;



    }

}