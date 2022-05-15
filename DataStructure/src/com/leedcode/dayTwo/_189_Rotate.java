package com.leedcode.dayTwo;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/2/12-3:05 下午
 */
public class _189_Rotate {

    public static void main(String[] args) {

        int[] arr={1,2};



    }


    /**
     * 借助额外空间（1）
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {


            k=k%nums.length;//k如果等于数组长度的整数倍等于没有进行旋转，只要对k%nums.length余数进行旋转就行了
            int[] arr = new int[nums.length];
            int index = 0;
            for (int i = nums.length - k; i < nums.length; i++) {
                arr[index++] = nums[i];
            }
            for (int i = 0; i < nums.length - k; i++) {
                arr[index++] = nums[i];
            }

            for (int i = 0; i < arr.length; i++) {

                nums[i] = arr[i];

            }
    }

    /**
     * 借助额外空间(2)
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k){
        int n=nums.length;
        k=k%n;
        int[] arr=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index=(i+k)%n;//移动后的位置
            arr[index]=nums[i];
        }
        //进行数组的拷贝
        System.arraycopy(arr, 0, nums, 0, n);
    }

    /**
     * 不借助额外空间--环状替换
     * 时间复杂度:O(n)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k){

        k=k%nums.length;
        int n=nums.length;
        int count=0;//记录元素移动的次数
        for (int start=0;count<n;start++){
            int curr=start;
            int pre=nums[start];
            //进行循环替换
            do {
                int next=(curr+k)%n;
                int temp=nums[next];
                nums[next]=pre;
                pre=temp;
                curr=next;
                count++;
            }while (start!=curr);

        }


    }

    /**
     * 数组反转
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k){

        //例:1234567  3
        //1.先全部反转 7654321
        //2.将0-k-1部分反转
        //3.将k到length-1部分反转

        k=k%nums.length;

        resrverArr(nums, 0, nums.length);
        resrverArr(nums, 0, k-1);
        resrverArr(nums, k, nums.length-1);




    }


    public void resrverArr(int[] arr,int start,int end){

        while (start<end){

            int temp=arr[start];

            arr[start]=arr[end];

            arr[end]=temp;

            start++;
            end--;

        }



    }








}