package com.leedcode.daySeven;

/**
 * @author lqw
 * @date 2022/3/23-11:50 上午
 */
public class _51_ReversePairsOffer {


    /**
     * 思路:使用归并排序
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {

        return sort(nums, 0, nums.length-1);

    }


    public int sort(int[] nums,int lo,int hi){

        if (lo>=hi) return 0;

        int mid=lo+((hi-lo)>>1);

        //进行分区

        //计算左边的逆序对的个数
        int leftCount=sort(nums, lo, mid);

        //计算右边逆序对的个数

        int rightCount=sort(nums, mid+1, hi);

        //进行合并操作

        int mergeCount=merge(nums,lo,mid,hi);


        return leftCount+rightCount+mergeCount;
    }

    public int merge(int[] nums,int left,int mid,int right){

        int index=0;//用于拷贝数组的下标

        int[] copyArr=new int[right-left+1];
        int p1=left;
        int p2=mid+1;
        int count=0;//记录逆序对
        while (p1<=mid&&p2<=right){
            //记录逆序对
            count+=nums[p1]>nums[p2]?(mid-p1+1):0;
            copyArr[index++]=nums[p1]<=nums[p2]?nums[p1++]:nums[p2++];
        }
        while (p1<=mid){
            copyArr[index++]=nums[p1++];
        }
        while (p2<=right){
            copyArr[index++]=nums[p2++];
        }

        //将排序好的数组放入原数组
        for (int i = 0; i < copyArr.length; i++) {
            nums[i+left]=copyArr[i];
        }
        return count;
    }
}