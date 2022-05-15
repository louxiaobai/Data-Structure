package com.leedcode.dayEleven;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/4/18-12:03 下午
 */
public class _973_KClosest {


    /**
     * 使用大顶堆进行求解
     *
     * 时间复杂度:O(nlogk)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {


        //(n2[0]*n2[0]+n2[1]*n2[1])-(n1[0]*n1[0]+n1[1]*n1[1])--构建一个大顶堆
        PriorityQueue<int[]> pq=new PriorityQueue<>(k+1,(n1,n2)->((n2[0]*n2[0]+n2[1]*n2[1])-(n1[0]*n1[0]+n1[1]*n1[1])));
        //将所有的值都进行加入到pd中进行判断
        for (int[] point:points){
            pq.add(point);

            if (pq.size()>k){

                pq.remove();
            }
        }
        //进行取值操作
        int[][] arr=new int[k][2];
        int index=0;
        while (!pq.isEmpty()){
            arr[index++]=pq.remove();
        }

        return arr;
    }
    /**
     * 进行升序排列--将二维数组按照升序 排列进行排 序
     * 然后用Arrays.copyOfRange(points,0,k) --取出二维数组的前k个
     *
     * 时间复杂度:nlogk
     * 空间复杂度:O(1)
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest1(int[][] points, int k) {


        //1.使用排序的方法进行求解

        Arrays.sort(points,(int[] n1,int[] n2)->((n1[0]*n1[0]+n1[1]*n1[1])-(n2[0]*n2[0]+n2[1]*n2[1])));


        return Arrays.copyOfRange(points, 0, k);


    }




}