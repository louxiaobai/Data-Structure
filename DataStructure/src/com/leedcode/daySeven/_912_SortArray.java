package com.leedcode.daySeven;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/21-12:06 下午
 */
public class _912_SortArray {


    public static void main(String[] args) {

        _912_SortArray sortArra = new _912_SortArray();

        int[] arr=new int[]{5,2,3,1};

        sortArra.sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));



    }

    public int[] sortArray(int[] nums) {

        insertSort(nums);

        return nums;

    }

    /**
     * 快速排序
     * @param arr
     * @param lo
     * @param hi
     */
    public void quickSort(int[] arr,int lo,int hi){


        if (lo>=hi) return;

        int left=lo;
        int right=hi;
        int index=left;

        int pivot=arr[right];//基准元素--正常这个基准元素要随机进行选择的而不是直接选择最后一个


        while (index<=right){


            if (arr[index]<pivot){

                int temp=arr[index];
                arr[index]=arr[left];
                arr[left]=temp;
                left++;
                index++;
            }else  if (arr[index]>pivot){
                int temp=arr[index];
                arr[index]=arr[right];
                arr[right]=temp;

                right--;
            }else {

                index++;
            }


            //分区完成进行递归

            quickSort(arr, lo, left-1);
            quickSort(arr, right+1, hi);

        }



    }

    /**
     * 使用插入排序
     * @param arr
     */
    public void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if (arr[j]<arr[j-1]){//进行交换
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }

    /**
     * 归并排序
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public void sort(int[] arr,int startIndex,int endIndex ){

        if (startIndex==endIndex) return;

        //对数组进行划分

        int mid=startIndex+((endIndex-startIndex)>>1);//取开始和结束的中点位置
        //对数组的左半边进行排序
        sort(arr, startIndex, mid);
        //对数组的右半边进行排序
        sort(arr, mid+1, endIndex);

        //进行合并操作
        mergeSort(arr, startIndex, mid, endIndex);
    }

    public void mergeSort(int[] arr,int left,int mid,int right){

        //创建一个临时数组用于存储排序好的数组

        int[] tempArr=new int[right-left+1];

        int index=0;//定义拷贝数组的下标

        int p1=left;//左半边数组的指针

        int p2=mid+1;//右半边数组的指针

        while (p1<=mid&&p2<=right){
            tempArr[index++]=arr[p1]<=arr[p2]? arr[p1++]:arr[p2++];
        }

        while (p1<=mid){
            tempArr[index++]=arr[p1++];
        }
        while (p2<=right){
            tempArr[index++]=arr[p2++];
        }
        //进行数组的赋值操作

        for (int i = 0; i <tempArr.length ; i++) {

            arr[left+i]=tempArr[i];

        }

    }


}