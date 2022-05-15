package com.leedcode.dayTwo;

/**
 * @author lqw
 * @date 2022/2/12-1:47 下午
 */
public class _941_ValidMountainArray {

    /**
     *时间复杂度:O(n)
     * 空间复杂度O(1)
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {



        if (arr.length<3) return false;

        int index=0;

        int length=arr.length-1;

        //找到数组的最高点
        while (index<length-1&&arr[index]<arr[index+1]) index++;

        //判断最高点是否为数组的最后一个元素或者为第一个元素
        if (index==length-1||index==0) return false;

        while (index<length-1&&arr[index]>arr[index+1]) index++;

        //

        return  index==length-1;




    }


}