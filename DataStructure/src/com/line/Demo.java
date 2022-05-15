package com.line;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.text.Caret;
import java.util.Arrays;

/**进行默写各种排序算法
 * @author lqw
 * @date 2021/10/25-2:04 下午
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr={123,232,12,32,1};
        //selectSort01(arr);//选择排序
        //insertSort01(arr);//插入排序1.0版本
        //insertSortO2(arr);//插入排序2.0版本
        //shellSort(arr);//插入排序3.0版本
        //bubbleSort(arr);//冒泡排序1.0版本
        //bubbleSort02(arr);//冒泡排序2.0版本
        //quickSort(arr,0,arr.length-1);//快速排序
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 进行选择排序
     * 不稳定排序
     * @param arr
     */
    public static void selectSort01(int[] arr){
        //每次从后面选择一个最小的元素
        for (int i = 0; i <arr.length ; i++) {
            int minIndex=i;
            for (int j=i; j <arr.length ;j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            if (minIndex!=i){//说明找到了 更小的元素 --进行更换
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]= temp;

            }
        }





    }
    /**
     * 插入排序 1.0版本
     * @param arr
     */
    public static  void insertSort01(int[] arr){

        //从后往前面进行插入操作
        for (int i=1;i<arr.length;i++){

            for (int j = i; j >0 ; j--) {

                if (arr[j]<arr[j-1]){//进行交换元素

                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }

            }
        }
    }
    /**
     * 插入排序2.0版本
     * @param arr
     */
    public static void insertSortO2(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int temp=arr[i];
            int j;
            for (j=i; j >0 ; j--) {
                if (temp<arr[j-1]){//进行移动元素
                    arr[j]=arr[j-1];
                }else{
                    break;
                }
            }
            arr[j]=temp;
        }
    }
    /**
     * 插入排序 3.0版本（希尔排序--插入排序的优化）
     *
     *不稳定排序
     * @param arr
     */
    public static void shellSort(int[] arr){

        int n=arr.length;
        int h=1;
        while (h<n/3){
            h=3*h+1;
        }

        while (h>=1){


            for (int i = 0; i <arr.length ; i++) {

                for (int j = i; j >=h; j=j-h) {

                     if (arr[j]<arr[j-h]){

                         int temp=arr[j];
                         arr[j]=arr[j-h];
                         arr[j-h]=temp;
                     }else{

                         break;
                     }

                }

            }




            h=h/3;
        }




    }
    /**
     * 冒泡排序1.0版本
     * 稳定排序
     * @param arr
     */
    public static void bubbleSort01(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j]>arr[j+1]){//进行交换元素
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }

        }

    }
    /**
     * 冒泡排序2.0
     * 稳定排序
     * @param arr
     */
    public static void bubbleSort02(int[] arr){

        //进行优化的方式:两个
        int index=arr.length-1;//用俩标志内层循环
        int last=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            //进一步优化-设置一个标志符号
            boolean flag=true;
            for (int j = 0; j <index; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;//优化一
                    last=j;//优化二
                }
            }
            index=last;
            if (flag){//表明没有交换的元素--元素全部有序 则不用再次进行循环操作
                break;
            }
        }
    }
    /**
     * 快速排序
     * 不稳定排序算法
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr,int lo,int hi){

        if (arr==null||arr.length==1) return ;
        if (lo>=hi) return ;//递归结束条件
        //进行分区
        int pivot=arr[hi];
        int left=lo;
        int right=hi;
        int i=left;//遍历元素使用
        while (i<=right){//进行交换元素的条件
            if (arr[i]<pivot){
                //进行交换元素
                int temp=arr[left];
                arr[left]=arr[i];
                arr[i]=temp;
                i++;
                left++;
            }else  if (arr[i]>pivot){
                int temp=arr[right];
                arr[right]=arr[i];
                arr[i]=temp;
                right--;
            }else{
                i++;
            }
        }
        //区分结束
        quickSort(arr, lo, left-1);
        quickSort(arr, right+1, hi);
    }
    /**
     * 归并排序
     * 稳定排序
     * @param arr
     */
    public static void mergeSort(int[] arr,int startIndex,int endIndex){
        if (arr==null||arr.length==1) return;
        if (startIndex==endIndex) return;
        int mid=startIndex+(endIndex-startIndex)/2;
        //进行左半边进行排序
        mergeSort(arr,startIndex,mid);
        mergeSort(arr, mid+1, endIndex);
        merge(arr,startIndex,mid,endIndex);//合并操作
    }
    /**
     * 归并操作
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr,int left,int mid,int right){
        int p1=left;
        int p2=mid+1;
        int index=0;//拷贝数组的下标
        int[] copyArr=new int[right-left+1];//创建一个辅助数组
        while (p1<=mid&&p2<=right){
            copyArr[index++]=arr[p1]<=arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            copyArr[index++]=arr[p1++];
        }
        while (p2<=right){
            copyArr[index++]=arr[p2++];
        }
        //对原数组进行赋值
        for (int i = 0; i < copyArr.length; i++) {
            arr[left+i]=copyArr[i];
        }

    }


}