package com.leedcode.offer;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**剑指 Offer 51. 数组中的逆序对-困难
 * @author lqw
 * @date 2021/10/9-2:14 下午
 */
public class ReversePairs{


    public static void main(String[] args) {

        int[] arr=new int[]{7,5,6,4};

        System.out.println( sort(arr, 0, arr.length-1));

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 对数组进行排序(归并排序)
     * @param data
     * @param startInde
     * @param endIndex
     */
    public static int sort(int[] data,int startInde,int endIndex) {

        if (startInde == endIndex) return 0;//递归出口
        int mid = startInde+((endIndex-startInde)>>1);
        int leftCunt = sort(data, startInde, mid);
        int rightCount = sort(data, mid + 1, endIndex);
        int mergeCount = merge(data, startInde, mid, endIndex);
        return leftCunt + rightCount + mergeCount;
    }
    /**
     * 对数组进行合并
     * @param data
     * @param startIndex
     * @param midIndex
     * @param endIndex
     */
    public static int merge(int[]data,int startIndex,int midIndex,int endIndex){
        int index=0;//拷贝数组的下标
        int[] copyArr=new int[endIndex-startIndex+1];//拷贝数组的大小
        int p1=startIndex;//定义左半部分数组的下标
        int p2=midIndex+1;//定义右半部分数组的下标
        int count=0;
        //对拷贝数组进行复制
        while (p1<=midIndex&&p2<=endIndex){
            //进行赋值操作操作
            count+=data[p1]>data[p2]?(midIndex+1-p1):0;//进行求逆序对
            copyArr[index++]=data[p1]<=data[p2]? data[p1++]:data[p2++];
        }
        while(p1<=midIndex){
            copyArr[index++]=data[p1++];
        }
        while (p2<=endIndex){

            copyArr[index++]=data[p2++];
        }
        //将排序好的copyArr赋值给原数组
        for (int i = 0; i <copyArr.length ; i++) {

            data[startIndex+i]=copyArr[i];
        }
        return count;
    }









}