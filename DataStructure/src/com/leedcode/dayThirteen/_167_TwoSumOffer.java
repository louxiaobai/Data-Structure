package com.leedcode.dayThirteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/4/29-3:32 下午
 */
public class _167_TwoSumOffer {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6,7};

        ArrayList<Integer> list=new ArrayList<>();


        demo(arr, 0, arr.length-1, list);


        System.out.println(Arrays.toString(list.toArray()));


    }



    /**
     * 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        //直接进行二分查找
        int left=0;
        int right=numbers.length-1;
        while (left<=right){
            int num=numbers[left]+numbers[right];
            if (num==target){
                return new int[]{left+1,right+1};
            }else if (num>target){

                right=right-1;

            }else {

                left=left+1;
            }




        }


        return numbers;


    }






    /**
     * 使用二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {


        int[] res=new int[2];

        for (int i = 0; i < numbers.length-1; i++) {


            int num=numbers[i];

            int num1 = find(numbers, i + 1, target - num);

            if (num1!=0){

                return new int[]{i+1,num1+1};
            }


        }

        return null;

    }

    /**
     * 二分查找
     * @return
     */
    public int find(int[] arr,int begin,int target){

        int left=begin;
        int right=arr.length-1;


        while (left<=right){

            int mid=left+(right-left)/2;

            if (arr[mid]==target){

                return mid;


            }else if (arr[mid]>target){

                right=mid-1;

            }else {


                left=mid+1;
            }
        }


        //找不到则进行返回0
        return 0;



    }


    public static void demo(int[] arr, int left, int right, ArrayList<Integer> list){

        if (right==1||left==arr.length-1) return;//递归出口

        if (list.size()==10) return ;//递归出口

        int mid=left+(right-left)/2;

        list.add(mid);

        demo(arr, left, mid, list);

        int t=mid;

        demo(arr, mid, right, list);

    }



}

