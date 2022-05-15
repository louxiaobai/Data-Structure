package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/5-11:28 上午
 */
public class _12_IntToRoman {

    /**
     * 思想:贪心算法思想
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        //数字数组
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        ///罗马数组

        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int index=0;
        StringBuilder sb=new StringBuilder();//用于存储阿拉伯数字
        while (index<13){//从最大的开始找起进行比对

            while (nums[index]<=num){

                sb.append(romans[index]);//存储对应的罗马数字

                num-=nums[index];
            }

            index++;


        }

        return sb.toString();

    }
}