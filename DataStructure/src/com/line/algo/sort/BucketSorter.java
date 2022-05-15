package com.line.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;


/**实现桶排序
 * @author lqw
 * @date 2021/9/29-3:38 下午
 */
public class BucketSorter {


    public static void main(String[] args) {

//        int[] data = new int[]{2, 5, 1, 23, 22, 33, 56, 12, 5, 3, 5, 6, 8, 2, 3, 4};
//        new BucketSorter().bucketSort(data);
//        System.out.println(Arrays.toString(data));
    }
    /**
     *进行桶排序
     * @param data
     */
    public static void bucketSort(int[] data){

        if (data==null||data.length<2) return;//不满足要求的数组则直接进行返回
        //进行分桶操作--根据最大元素的数值进行分桶，桶的个数为最大元素除10+1
        //桶的个数可以根据业务需要进行划分,这里没有统一的要求
        //取出数组中元素的最大值
        int maxValue=data[0];

        for (int datum : data) {

            maxValue=Math.max(maxValue, datum);

        }

        int bucketNum=maxValue/10+1;//得到了桶的个数

        ArrayList<Integer>[] buckets=new ArrayList[bucketNum];

        //将对应的元素添加到桶中
        for (int i = 0; i <data.length; i++) {

            int index=data[i]/10;

            //如果桶没有创建则进行创建桶
            if (buckets[index]==null){

                buckets[index]=new ArrayList<Integer>();

            }
            buckets[index].add(data[i]);

        }
        //对每一个桶中国的元素进行排序---可以选择任意排序算法进行排序
        //这里选择快速排序-快速排序效率高
        for (int i = 0; i <bucketNum ; i++) {

            ArrayList<Integer> bucket = buckets[i];//得到具体桶的数据
            //对桶内的数据进行排序

            if (bucket!=null){//如果桶内元素不为空则对其进行排序

                 ArrayQuickSorter.sort(bucket);
            }

        }
        //从bucket中拿到排序后的数组
        int index=0;
        for (int i = 0; i <bucketNum; i++) {

            ArrayList<Integer> bucketData=buckets[i];

            if (bucketData!=null){
                for (int j = 0; j < bucketData.size(); j++) {
                    data[index++] = bucketData.get(j);
                }
            }


            
        }

    }





}