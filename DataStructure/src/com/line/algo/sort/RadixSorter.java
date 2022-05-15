package com.line.algo.sort;

import java.util.Arrays;

/**实现基数排序--其本质是计数排序
 * @author lqw
 * @date 2021/9/30-9:29 上午
 */
public class RadixSorter {

    public static void main(String[] args) {

        int[] data=new  int[]{100,213,123,324,4356,1233};
        //找到最大值
        int max=data[0];

        for (int datum : data) {

            max=Math.max(max, datum);

        }

        for (int exp = 1; max/exp>0 ; exp*=10) {
            radxSorter(data,exp);
        }

        System.out.println(Arrays.toString(data));
    }
    /**
     * 实现基数排序
     * @param data
     * 先实现个位数上的排序
     */
    public static void radxSorter(int[] data,int exp){

         //1.先确定最大数和最小数
         int max=9;
         int min=0;
        //确定计数数组的大小
        int [] count=new int[max-min+1];
        //对计数数组进行赋值
        for (int i = 0; i <data.length; i++) {
            //个位数:(234/1)%10
            //十位数:(234/10)%10
            //百位数:(234/100)%10
            //千位数:(2340/1000)%10
            int digit=(data[i]/exp)%10;//取到个位上的数据
            count[digit]++;
        }
        //对计数数组执行累加操作
        int sum=0;
        for (int i = 0; i <count.length ; i++) {
            sum+=count[i];
            count[i]=sum;

        }

        //执行排序功能-创建一个辅助数组

        int[] sort=new int[data.length];


        for (int i = data.length-1; i >=0 ; i--) {

            int j=(data[i]/exp)%10;
            int k=count[j-min]-1;
            sort[k]=data[i];
            count[j-min]--;
        }

        for (int i = 0; i <sort.length ; i++) {
            data[i]=sort[i];
        }
    }
}