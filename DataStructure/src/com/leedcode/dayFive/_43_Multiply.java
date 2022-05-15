package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/7-11:26 上午
 */
public class _43_Multiply {

    /**
     * 思路:两个数字进行想成-对应的数字下表的i+j+1就是每次数字相乘所存放的位置,将进位的数放在i+j的位置上，
     * 时间复杂度:O(n*m)
     * 空间复杂度:O(n+m)
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {


        if (num1.equals("0")||num2.equals("0")) return "0";

        //创建一个数组进行存储两数相乘之后的结果
        //两数相乘 最多有 num1.length+num2.lenght的长度
        int[] arr=new int[num1.length()+num2.length()];


        for (int i = num1.length()-1; i >=0 ; i--) {//从后往前进行遍历

                int n1=num1.charAt(i)-'0';
            for (int j = num2.length()-1; j >=0 ; j--) {//i+j+1是数字计算之后的位置

                int n2=num2.charAt(j)-'0';

                int sum=arr[i+j+1]+n1*n2;

                arr[i+j+1]=sum%10;

                arr[i+j]+=sum/10;


            }

        }

        //对数组进行处理

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < arr.length; i++) {

            if (i==0&&arr[i]==0) continue;

            sb.append(arr[i]);

        }

        return sb.toString();
    }


}