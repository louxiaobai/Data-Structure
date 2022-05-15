package com.leedcode.daySeven;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/15-11:28 上午
 */
public class SortTest {


    public static void main(String[] args) {

        int[] arr={1,3,2,3,1,3,4,5,12,324,23};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 插入排序
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * 稳定：不稳定排序
     * @param arr
     */
    public  static  void selectSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int min=i;
            boolean flag=false;
            for (int j = i+1; j <arr.length ; j++) {//找到最小值
                if (arr[j]<arr[min]){
                    min=j;
                    flag=true;
                }
            }
            //进行交换元素
            if (flag){
                int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
            }

        }

    }

    /**
     * 插入排序
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * 稳定:稳定排序
     * @param arr
     */
    public static void insetSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j >0; j--) {

                if (arr[j]<arr[j-1]){//进行交换元素

                    int temp=arr[j];

                    arr[j]=arr[j-1];

                    arr[j-1]=temp;

                }

            }

        }

    }

    /**
     * 希尔排序--插入排序的优化--间隔排序发
     * 时间复杂度:O(n^3/2)
     * 空间复杂度:O(1)
     * 稳定:不稳定排序算法
     * @param arr
     */
    public static void shellSort(int[] arr){

        int n=arr.length-1;

        int h=1;

        while (h<n/3){
            h=h*3+1;//每次的间隔距离
        }

        while (h>=1){//对数组进行排序

            for (int i = h; i < arr.length-1; i++) {

                for (int j = i+1; j >=h ; j=j-h) {

                    if (arr[j]<arr[j-h]){//进行交换元素

                        int temp=arr[j];
                        arr[j]=arr[j-h];
                        arr[j-h]=temp;
                    }

                }

            }

            h=h/3;
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * 稳定:稳定排序算法
     * @param arr
     */
    public static void bubbleSort(int[] arr){

        int index=arr.length-1;
        int last=0;//记录最后一个拍好序的下标
        for (int i = 0; i <arr.length-2 ; i++) {
            boolean flag=true;
            for (int j = 0; j <index; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    last=j;
                    flag=false;//只要进去交换就说明没有完全拍好序列
                }
            }
            index=last;
            if (flag){
                break;//结束循环- 全部有序
            }
        }
    }


    public static void quickSort(int[] arr,int lo,int hi){

        if (arr==null||arr.length<=1) return;//判断数据是是否符合排序条件
        if (lo>=hi) return;//说明排序完成
        int pivot=arr[hi];//定义一个基准元素
        int left=lo;
        int right=hi;
        int index=left;
        //进行排序-将大于pivot的放在基准元素的右边，将小于pivot的元素放在基准元素的左边-直到 index<=right为止
        while (index<=right){
            if (arr[index]<pivot){//将元素放在pivot的左边
                int temp=arr[index];
                arr[index]=arr[left];
                arr[left]=temp;
                index++;
                left++;
            }else if (arr[index]>pivot){

                int temp=arr[index];
                arr[index]=arr[right];
                arr[right]=temp;
                right--;
            }else {
                index++;
            }
        }
        //分区结束
        quickSort(arr, lo, left-1);
        quickSort(arr, right+1, hi);
    }


}