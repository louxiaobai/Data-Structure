package com.leedcode.bs;

/**山脉数组的峰顶索引 leedcode 852 -简单
 * @author lqw
 * @date 2021/10/19-9:11 下午
 */
public class PeakIndexInMountainArray {

    public static void main(String[] args) {

        int[] arr={0,5,3,1};;

        System.out.println(peakIndexInMountainArray(arr));

    }


    /**
     * 使用二分查找进行找到峰值
     * @param arr
     * @return
     */

    public static int peakIndexInMountainArray(int[] arr){

        int left=0;
        int right= arr.length-1;

        int mid=0;
        //可以知道f山脉数组一侧是 逆序排列 一侧是正序排列
       while (left<=right){

            mid=left+(right-left)/2;

            if (arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){

                  return  mid;//得到峰值的下标

            }else if (arr[mid]<arr[mid+1]){

                 left=mid+1;

            }else {

                right=mid;
            }



        }

        return mid;

    }



}