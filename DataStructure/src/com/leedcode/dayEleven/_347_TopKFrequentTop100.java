package com.leedcode.dayEleven;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/4/18-11:35 上午
 */
public class _347_TopKFrequentTop100 {


    /**
     * 解题思路:将创建一个hashmap进行维护键值对,以数组的值为键 出现的次数为值map.put(num[i],map.getOrDefault(num,0)+1)
     * //创建一个小顶堆  PriorityQueue<Integer> pq=new PriorityQueue<>(k+1,(n1,n2)->map.get(n1)-map.get(n2))
     * 将数组中元素依次放入到堆中如果堆中的元素 pq.size()>k 则将堆中的最小元素进行删除
     * 时间复杂度:nlogk
     * 空间复杂度:n
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {


        //1.创建一个hashMap进行存储键和值

        HashMap<Integer,Integer> map=new HashMap<>();


        for(int num:nums){

            map.put(num, map.getOrDefault(num, 0)+1);

        }

        //2.进行创建一个小顶堆进行求解出现频率最高的 第k个元素


       PriorityQueue<Integer> pq=new PriorityQueue<>(k+1,(n1,n2)->map.get(n1)-map.get(n2));


        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size()>k){
                pq.remove();
            }
        }
        int[] arr=new int[k];
        int index=0;
        while (!pq.isEmpty()){
            arr[index]=pq.peek();
            index++;
            pq.remove();

        }

        return arr;
    }
}