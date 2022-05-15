package com.leedcode.dayEleven;

import java.util.*;

/**
 * @author lqw
 * @date 2022/4/19-10:46 下午
 */
public class _703_KthLargest {

    PriorityQueue<Integer> pq=null;
    int k;
    public _703_KthLargest(int k, int[] nums) {
        //数组容量为k 小顶堆
        pq=new PriorityQueue<>(k);
        this.k=k;
        for (int num :nums){
            if (pq.size()<k){
                pq.add(num);
            }else if (pq.size()==k&&pq.peek()<num){
                pq.remove();
                pq.add(num);
            }
        }
    }

    public int add(int val) {


        if (pq.size()<k){

            pq.add(val);
        }else if (pq.size()==k&&pq.peek()<val){

            pq.remove();
            pq.add(val);

        }

        return pq.peek();

    }



}