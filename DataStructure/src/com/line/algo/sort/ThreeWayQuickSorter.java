package com.line.algo.sort;

import sun.util.resources.cldr.rof.CurrencyNames_rof;

import java.util.Arrays;

/**三路快排--实现这种情况  1，2，4，【7，7，7】10，21，230---重复元素放在中间
 * 快速排序每次排序都可以确定一个元素的固定位置
 * @author lqw
 * @date 2021/9/28-9:59 上午
 */
public class ThreeWayQuickSorter {

//    //私有内部类
//    private static class PartitionSegment{
//
//        public int less;
//        public int great;
//
//        public PartitionSegment(int less,int great){
//            this.less=less;
//            this.great=great;
//        }
//    }
    public static void main(String[] args) {
        int[] data=new int[]{1,2,3,45,6,7,831,23,1,2,23};
        sort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] data,int lo,int hi){

        if (data==null||data.length<=1) return;//判断数据是是否符合排序条件
        if (lo>=hi) return;//递归结束条件
        //进行分区--开始
        int pivot=data[hi];
        int less=lo;
        int great=hi;
        int i=lo;
        while (i<=great){
            if (data[i]<pivot){//进行元素交换
                int temp=data[i];
                data[i]=data[less];
                data[less]=temp;
                less++;
                i++;
            }else if (data[i]>pivot){
                int temp=data[i];
                data[i]=data[great];
                data[great]=temp;
                great--;
            }else{
                i++;
            }
        }
        //分区结束
        sort(data,lo,less-1);
        sort(data, great+1, hi);
    }

    /**
     * 返回一个包含 下标最大左边元素和下标最小右边元素
     * @param data
     * @param lo
     * @param hi
     * @return
     */
//    public static PartitionSegment partition(int[] data,int lo,int hi){
//        int pivot=data[hi];
//        int less=lo;
//        int great=hi;
//        int i=lo;
//        while (i<=great){
//            if (data[i]<pivot){//进行元素交换
//                int temp=data[i];
//                data[i]=data[less];
//                data[less]=temp;
//                less++;
//                i++;
//            }else if (data[i]>pivot){
//                int temp=data[i];
//                data[i]=data[great];
//                data[great]=temp;
//                great--;
//            }else{
//                i++;
//            }
//        }
//        return new PartitionSegment(less, great);
//    }
}