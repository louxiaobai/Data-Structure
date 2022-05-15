package com.leedcode.daySeven;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/26-11:49 上午
 */
public class _493_ReversePairs {


    public static void main(String[] args) {
        _493_ReversePairs reversePairs = new _493_ReversePairs();
        int[] arr=new int[]{2,4,3,5,1};
        System.out.println(reversePairs.reversePairs(arr));
    }


    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }
    public int sort(int[] nums,int lo,int hi){

        if (lo>=hi) return 0;

        int mid=lo+((hi-lo)>>1);

        int leftCount=sort(nums, lo,mid);

        int rightCount=sort(nums, mid+1, hi);


        //在合并前进行计符合条件的反转对

        int i=lo;
        int j=mid+1;
        int count=0;

        while (i<=mid){
            while (j<=hi&&(long)nums[i]>(long)2*nums[j]) j++;
            count+=(j-mid-1);
            i++;
        }

        merge(nums,lo,mid,hi);

        return leftCount+rightCount+count;
    }

    public void merge(int[] nums,int left,int mid,int right){


        int index=0;

        int[] copyArr=new int[right-left+1];

        int p1=left;
        int p2=mid+1;

        int count=0;

        while (p1<=mid&&p2<=right){

            copyArr[index++]=nums[p1]<=nums[p2]?nums[p1++]:nums[p2++];
        }

        while (p1<=mid){

            copyArr[index++]=nums[p1++];
        }

        while (p2<=right){


            copyArr[index++]=nums[p2++];

        }

        for (int i = 0; i < copyArr.length; i++) {

            nums[i+left]=copyArr[i];

        }


    }



}