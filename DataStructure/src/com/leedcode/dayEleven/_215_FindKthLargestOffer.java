package com.leedcode.dayEleven;

import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/4/16-1:20 下午
 */
public class _215_FindKthLargestOffer {


    /**
     * 继续优化--因为数组长度如果过大,而且k值过大的话,那么可能会造成创建的额外时间复杂度更多,此时需要对k值进行判断
     * 来做决定最后是使用大顶堆还是小顶堆--根据k的值来决定使用什么堆结构
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        int n=nums.length;
        //进行特判
        if (k==1&&n==1) return nums[0];

        int capacity;//先进行初始化堆的空间

        PriorityQueue<Integer> pq=null;//进行初始化 一个 堆结构
        if (k>n-k){//如果k大于n-k 说明此时k值较大 需要使用大顶堆进行求解
            capacity=n-k+1;
            pq=new PriorityQueue<>(capacity+1,(n1,n2)->n2-n1);//大顶堆结构
        }else {
            capacity=k;
            pq=new PriorityQueue<>(capacity+1);
        }
        //进行堆结构遍历

        for (int i = 0; i < nums.length; i++) {


            pq.offer(nums[i]);
            if (pq.size()>capacity){
                pq.remove();
            }
        }

        return pq.peek();

    }


    /**
     * 使用小顶堆进行求解
     * 时间复杂度:O(nlogk)
     * 空间复杂度:O(k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        //进行特判
        if (k==1&&nums.length==1) return nums[0];

        //初始化k个元素
        PriorityQueue<Integer> heap=new PriorityQueue<>(k);


        //先将数组的前k个指存储到数组中
        for (int i = 0; i <k ; i++) {

            heap.offer(nums[i]);

        }

        //在对数组中的后k个值进行遍历操作

        for (int i = k; i < nums.length; i++) {

            if (nums[i]>heap.peek()){//进行删除堆顶元素 然后进行添加新元素

                heap.remove();//弹出堆顶的值
                heap.offer(nums[i]);

            }

        }


        return heap.peek();


    }

    /**
     * 使用大顶堆进行求解
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {

        //进行特判
        if (k==1&&nums.length==1) return nums[0];
        //创建一个大顶堆
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2)->n2-n1);//大顶堆
        for (int num : nums) {
            heap.offer(num);
        }
        while (heap.size()>0){
            k--;
            int num=heap.poll();
            if (k==0) return num;
        }
        return 0;
    }

}