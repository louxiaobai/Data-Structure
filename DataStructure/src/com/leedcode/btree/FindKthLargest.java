package com.leedcode.btree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/1/20-8:19 上午
 */
public class FindKthLargest {


    public static void main(String[] args) {

        int[] nums=new int[]{2,1};

        //1 2 3 4 5 6

        //1 2 2 3 3 4 5 5 6
        System.out.println(findKthLargest(nums,1));


    }

    /**
     * 优先队列解法--堆排序--进行优化
     * 时间复杂度O(min(k,n-k))
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        if (k < len - k) {
            //1.运用小顶堆进行求解--前提k的值不大,如果太大则会导致 小根堆浪费的空间多
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);//只需要k的容量的小顶堆进行维护数据
            //(1).先将数组中前k个元素进行存储到小顶堆中
            for (int i = 0; i < k; i++) { //时间复杂度O(k*logk)
                minHeap.offer(nums[i]);
            }
            //(2) 对元素进行比较 如果新进来的元素大于小根堆的堆顶元素
            for (int i = k; i < nums.length; i++) { //(n-k)logk
                if (nums[i] > minHeap.peek()) {
                    minHeap.remove();//移除最小的元素
                    minHeap.offer(nums[i]);
                }
            }
            return minHeap.peek();
        } else {

            int capacity = nums.length - k + 1;//k值比较大
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
            //(1).先将数组中前k个元素进行存储到小顶堆中
            for (int i = 0; i < capacity; i++) {
                maxHeap.offer(nums[i]);
            }
            //(2) 对元素进行比较 如果新进来的元素大于小根堆的堆顶元素
            for (int i = capacity; i < nums.length; i++) {
                if (nums[i] < maxHeap.peek()) {
                    maxHeap.remove();//移除最大的元素
                    maxHeap.offer(nums[i]);
                }
            }
            return maxHeap.peek();
        }
    }

//        //大顶堆
//        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        int index=0;
//        for (int num : nums) {
//            heap.offer(num);
//        }
//        while (--k>=0){
//            index=heap.remove();
//        }
//        return index;



    /**
     * 时间复杂度
     * 空间复杂度O(1)
     * 使用快排进行求解--快速排序每次排序都可以确定一个元素的固定位置
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k){

        sort(nums, 0, nums.length-1);//对数组进行排序完成




        return nums[nums.length-k];
    }


    public static void sort(int[] nums,int begin,int end){

        //快拍结束条件
        if (begin>=end) return;
        int lo=begin;
        int hi=end;
        int index=lo;//标记元素

        //选取最后一个元素为枢纽元素
        int pivot=nums[end];
        //进行分区

        while (index<=hi){
            //进行分情况讨论
            if (nums[index]<pivot){
                //如果当元素比基准元素小则需要进行元素交换
                int temp=nums[index];
                nums[index]=nums[lo];
                nums[lo]= temp;
                index++;
                lo++;

            }else if (nums[index]>pivot){

                //如果当元素比基准元素大则需要进行元素交换
                int temp=nums[index];
                nums[index]=nums[hi];
                nums[hi]=temp;
                hi--;
            }else{

                index++;
            }

            //分区结束--进行递归快拍
            sort(nums, begin, lo-1);
            sort(nums, hi+1, end);


        }





    }


}