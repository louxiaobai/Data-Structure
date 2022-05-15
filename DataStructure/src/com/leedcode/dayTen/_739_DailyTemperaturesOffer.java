package com.leedcode.dayTen;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/4/11-3:46 下午
 */
public class _739_DailyTemperaturesOffer {

    public static void main(String[] args) {

        int[] arr=new int[]{73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(dailyTemperatures(arr)));

    }


    /**
     * 使用单调栈
     * 思路:将元素全挨个放到stack中 然后让将 遍历到的数组的值的大小 和栈中指针所值的大小做对比,如果大于
     * 栈中指针所指的大小则将栈中的索引弹出 更新 res数组中的 i-index 位置的数,然后将i 入栈中
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {

        ArrayDeque<Integer> stack=new ArrayDeque<>();
        //创建一个数组--默认长度为0
        int[] res=new int[temperatures.length];
        stack.push(0);
        //对数组进行遍历操作
        for (int i = 1; i < temperatures.length; i++) {
            //始终拿数组遍历到的元素和栈顶指针所对应的元素做对比-要循环做对比 因为可能当前值比多个值都大
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int index=stack.pop();
                res[index]=i-index;

            }
            stack.push(i);
        }

        return res;


    }

    /**
     * 暴力解法-超时
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(n)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {


        int[] arr=new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            boolean flag=false;
            int index=0;
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[i]<temperatures[j]){
                    index=j-i;
                    flag=true;
                    break;
                }
            }
            if (flag){
                arr[i]=index;
            }else {
                arr[i]=0;
            }
        }
        return arr;

    }
}