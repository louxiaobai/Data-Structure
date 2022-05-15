package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/2-11:29 上午
 */
public class _852_PeakIndexInMountainArrayOffer {


    public static void main(String[] args) {

        int[] arr=new int[]{3,5,3,2,0};
        System.out.println(peakIndexInMountainArray(arr));

    }

    /**
     * //可以知道一点山顶的左右两边都是有元素的--找到中点后判断他和它后面的一个元素--来进行判断它是处于上升阶段还是下降阶段
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray(int[] arr) {



        if (arr==null||arr.length==0) return -1;

        int left=0;

        int right=arr.length-1;
        while (left<right){//可以知道一点山顶的左右两边都是有元素的--找到中点后 一定是一边是有序的 而另一边是无序列的
            int mid=left+(right-left)/2;
            if (arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]) return mid;
            if (arr[mid]>arr[mid-1]){//说明最大值在右边
                 left=mid+1;
            }else {//这里为什么不能mid加一，因为left+(right-left)/2;是向下取整,如果-1 可能会发生数组越界
                right=mid;
            }
        }
        return -1;
    }

    /**
     * 不断排除不合法的空间
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray1(int[] arr) {

        if (arr==null||arr.length==0) return -1;

        int left=0;

        int right=arr.length-1;

        while (left<right){//使用不断排除不合法的空间

            int mid=left+(right-left)/2;

            if (arr[mid]<arr[mid+1]){//说明此时正在处于上升阶段 顶峰在右边


                left=mid+1;

            }else{//此时处于下降阶段顶峰在左--如果在此时判断 mid 也有可能是最大值 故 right=mid 不必要减去一


                right=mid;

            }
        }

        return left;

    }



}