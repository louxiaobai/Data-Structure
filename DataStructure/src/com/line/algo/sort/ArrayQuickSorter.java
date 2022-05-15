package com.line.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**对ArrayList存储的数据进行排序
 * @author lqw
 * @date 2021/9/29-5:26 下午
 */
public class ArrayQuickSorter {


    public static void sort(ArrayList<Integer> data) {

        if (data == null || data.size() <= 1) return;
        Integer[] dataArr = data.toArray(new Integer[data.size()]);
        sort(dataArr, 0, dataArr.length - 1);
        data.clear(); // 清空
        for (Integer i : dataArr) data.add(i);
    }

    public static void sort(Integer[] data,int lo,int hi){

        if (lo>=hi) return;//递归结束条件
        int i=lo;
        int left=lo;
        int right=hi;
        int pivot=data[hi];//取最右边的元素的基准元素
        while (i<=right){
            if (data[i]<pivot){

                int temp=data[i];
                data[i]=data[left];
                data[left]=temp;
                i++;
                left++;
            }else if (data[i]>pivot){
                int temp=data[i];
                data[i]=data[right];
                data[right]=temp;
                right--;

            }else{

                i++;
            }
        }
        //进行递归排序
        sort(data, lo, left-1);
        sort(data, right, hi);

    }


}