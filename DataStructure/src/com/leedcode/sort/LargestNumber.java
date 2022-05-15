package com.leedcode.sort;

import java.util.Arrays;

/**179题--最大数--中等难度
 * @author lqw
 * @date 2021/10/5-6:40 下午
 */
public class LargestNumber {

    public static void main(String[] args) {


    }


    public static String largestNumber(int[] nums){

        //1.对数组进行排序
        sort(nums, 0, nums.length-1);

        if (nums[0]==0) return "0";

        //2.将排序好的数据进行拼接然后打印处理

        StringBuilder sb=new StringBuilder();

        for (int num : nums) {
            sb.append(num);

        }
        return sb.toString();

    }


    /**
     * 实现快排
     * @param data
     */
    public  static  void sort(int[] data,int lo,int hi){
        if (lo>=hi) return;//进行快排的出口
        int left=lo;
        int right=hi;
        int pivot=data[right];//基准元素
        int index=left;
        while (index<=right){
            String xy=data[index]+""+pivot;
            String yx=pivot+""+data[index];
            if (xy.compareTo(yx)>0){
                //进行元素交换
                int tem=data[left];
                data[left]=data[index];
                data[index]=tem;
                index++;
                left++;
            }else if (xy.compareTo(yx)<0){
                int tem=data[right];
                data[right]=data[index];
                data[index]=tem;
                right--;
            }else{
                index++;
            }
        }
        sort(data, lo, left-1);
        sort(data, right+1, hi);
    }


}