package com.leedcode.daySeven;

import javax.sound.midi.SoundbankResource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/3/24-10:30 上午
 */
public class _315_CountSmaller {

    //创建一个ans数组用来存储统计的数据
    int[] index;//用于记录每个元素的初始信息
    int[] count;//用于统计数组中每个数逆序的个数
    List<Integer> list=new ArrayList<>();
    public List<Integer> countSmaller(int[] nums) {
        count=new int[nums.length];
        index=new int[nums.length];
        //记录原始数组每个元素的索引信息,方便在合并的时候知道计算的是那一个元素
        for (int i = 0; i < nums.length; i++) {
            index[i]=i;
        }
        sort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            list.add(count[i]);
        }
        return list;
    }
    public void sort(int[] nums,int leftindex,int rightIndex){
        if (leftindex>=rightIndex) return;//递归结束条件
        int mid=(leftindex+rightIndex)/2;
        //对左边进行排序
        sort(nums, leftindex, mid);
        //对右边进行排序
        sort(nums, mid+1, rightIndex);
        merge(nums,leftindex,mid, rightIndex);
    }
    //升序排列
    public void merge(int[] nums,int leftIndex,int midIdex,int rightIndex){
         //创建临时数组存储存储有序的 初始数组
         int[] copyArr=new int[rightIndex-leftIndex+1];
         //创建历史数组的索引数组
         int[] indexArr=new int[rightIndex-leftIndex+1];
         int p1=leftIndex;
         int p2=midIdex+1;
         int cur=0;
         while (p1<=midIdex&&p2<=rightIndex){
             if (nums[p1]<=nums[p2]){//如果合并中的数组 左边小于右边则进行如下操作
                 //当nums[p2]>=nums[p1]时候可以统计 出现的逆序对数为 rightIndex-minIndex+1
                 count[index[p1]]+=(p2-midIdex-1);
                 indexArr[cur]=index[p1];//记录元素交换后的位置
                 copyArr[cur]=nums[p1];
                 p1++;
             }else{
                 copyArr[cur]=nums[p2];
                 indexArr[cur]=index[p2];
                 p2++;
             }
             cur++;
         }
        while (p1<=midIdex){
             //当右边元素走完 但是左边元素没有走完,此时也需要统计
             count[index[p1]]+=(p2-midIdex-1);
             indexArr[cur]=index[p1];//记录元素交换后的位置
             copyArr[cur]=nums[p1];
             p1++;
             cur++;
        }
        while (p2<=rightIndex){
            indexArr[cur]=index[p2];//记录元素交换后的位置
            copyArr[cur]=nums[p2];
            p2++;
            cur++;
        }
        //数据进行赋值
        for (int i = 0; i < copyArr.length; i++) {
            nums[i+leftIndex]=copyArr[i];
            index[i+leftIndex]=indexArr[i];
        }
    }
}