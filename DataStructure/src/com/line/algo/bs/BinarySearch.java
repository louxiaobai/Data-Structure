package com.line.algo.bs;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;

/**二分查找的变形问题
 * @author lqw
 * @date 2021/10/10-10:14 上午
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] data=new int[]{1,2,3,4,5,6,6,6,7,7,8,9};

        System.out.println(lastLETragetElement(data,7));
    }
    /**
     * 二分查找--查找最小下标的目标元素
     * @param data
     * @param target
     * @return
     */
    public static int firstTargetElement(int[] data,int target){

        if (data==null||data.length==0) return -1;
        int left=0;
        int right=data.length-1;


        while (left<=right){
            int mid=left+(right-left)/2;
            if (target==data[mid]){

                //mid是数组的第一个元素 则直接返回
                //mid的前一个元素不等于 target
                if (mid==0||data[mid-1]!=target) return mid;

                else right=mid-1;

            }else if (target<data[mid]){


                 right=mid-1;

            }else {

                left=mid+1;
            }

        }



        return -1;



    }

    /**
     * 二分查找--查找第一个大于等于目标元素的下表
     * @param data
     * @param target
     * @return
     */
    public static int fisrtGETargetElement(int[] data,int target){
        if (data==null||data.length==0) return -1;
        int left=0;
        int right=data.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (data[mid]>=target){
                //符合下面的两个条件之一就返回mid
                //1.mid 是数组的第一个元素
                //2.min 前面的那个元素小雨target
                if (mid==0 || data[mid-1]>target) return mid;
                else right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    /**
     * 二分查找--查找到最后一个等于目标元素的下标
     * @param data
     * @param target
     * @return
     */
    public static int lastTargetElement(int[] data,int target){

        if (data==null||data.length==0) return -1;
        int left=0;
        int right=data.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (target==data[mid]){
                if (mid==data.length-1||data[mid+1]!=target) return mid;
                else left=mid+1;
            }else if (target<data[mid]){

                right=mid-1;

            }else {

                left=mid+1;
            }

        }



        return -1;



    }

    /**
     * 二分查找-查找到最后一个小于等于目标值的下标
     * @param data
     * @param target
     * @return
     */
    public static int lastLETragetElement(int[] data,int target){

        if (data==null||data.length==0) return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (data[mid]<=target){
                if (mid==data.length-1|| data[mid+1]>target) return mid;
                else left=mid+1;
            }else {
                right=mid-1;
            }
        }

        return -1;
    }

}