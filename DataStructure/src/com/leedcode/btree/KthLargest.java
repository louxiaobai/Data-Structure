package com.leedcode.btree;

import java.util.PriorityQueue;

/**703. 数据流中的第 K 大元素
 * @author lqw
 * @date 2022/1/20-11:14 上午
 */
public class KthLargest {


    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap=new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size()<k){
                minHeap.offer(nums[i]);
            }else if (minHeap.size()==k&&minHeap.peek()<nums[i]){
                minHeap.remove();
                minHeap.offer(nums[i]);
            }

        }

    }

     //时间复杂度O(logn)
     //空间复杂度O(1)
    public int add(int val) {

        //进行判断

        if (minHeap.size()<k){

            minHeap.offer(val);

        }else if (minHeap.size()==k&&minHeap.peek()<val){
            minHeap.remove();
            minHeap.offer(val);

        }


        return minHeap.peek();



    }


}