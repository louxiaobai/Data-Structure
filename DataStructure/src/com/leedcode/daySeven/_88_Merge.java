package com.leedcode.daySeven;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/23-10:38 上午
 */
public class _88_Merge {

    public static void main(String[] args) {

        int[] num1={1,2,3,0,0,0};

        int m=3;

        int[] num2={2,5,6};

        int n=3;

        merge(num1,m,num2,n);

        System.out.println(Arrays.toString(num1));

    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        int k=m+n-1;//数组的最后一个位置
        int i=m-1;
        int j=n-1;
        while (j>=0){
            if (i<0||nums2[j]>nums1[i]){
                nums1[k--]=nums2[j--];
            }else {
                nums1[k--]=nums1[i--];
            }
        }
    }
    /**
     * 实现思路:参考归并排序的合并操作--有个缺点空间复杂度有点大
     * 空间复杂度:O(n)
     * 时间复杂度:O(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        //创建一个额外空间
        int index = 0;
        int[] arr = new int[m+n];
        //m-n则是num1数组中有数据的部分
        int index1 = 0;
        int index2 = 0;

        while (index1 < m && index2 < n) {

            arr[index++] = nums1[index1] <= nums2[index2] ? nums1[index1++] : nums2[index2++];


        }


        while (index1 <  m) {

            arr[index++] = nums1[index1++];

        }

        while (index2 < n) {




            arr[index++] = nums2[index2++];

        }

        for (int i = 0; i <arr.length; i++) {

             nums1[i]=arr[i];

        }




    }



}