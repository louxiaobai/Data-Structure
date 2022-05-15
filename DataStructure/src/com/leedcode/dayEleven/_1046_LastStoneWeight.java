package com.leedcode.dayEleven;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/4/16-11:27 上午
 */
public class _1046_LastStoneWeight {

    public static void main(String[] args) {


        int[] arr=new int[]{2,3,4,5,1,212,32};

        lastStoneWeight(arr);

    }

    /**
     * 使用大顶堆进行求解--java中内置的是小顶堆--进行 转换下 成大顶堆
     *
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        //java中默认的是小顶堆
        Queue<Integer> heap=new PriorityQueue<>((n1,n2)->n2-n1);//实现大顶堆
        for (int stone : stones) {
            heap.offer(stone);
        }
        //得到一个大顶堆
        while (heap.size()>=2){
            int x=heap.poll();
            int y=heap.poll();
            if (x>y){
                heap.offer(x-y);
            }
        }
        return heap.size()==0?0:heap.poll();

    }

    /**
     * 使用排序的方法进行求解
     * 思路:遍历次数为数组的长度 每次遍历都需要对 数组进行排序
     * 取出 倒数第一个值和倒数第二个值 每次都将倒数第一个第二个值进行赋0操作,倒数第一个为 为 x-y
     * 在遍历过程中需要进行特殊判断如果排序完成之后 倒数第二个值为0 则 直接跳出循环
     * 最后返回最后一个元素的值
     * 时间复杂度:O(n^2logn)
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight1(int[] stones) {


        int n=stones.length;

        for (int i = 0; i < stones.length-1; i++) {//进行循环次数 每次挑选出来两快石头
            //对数组进行排序
            Arrays.sort(stones);
            int x=stones[n-1];
            int y=stones[n-2];
            if (x==0) break;//说明只剩一个石头--直接跳出循环
            stones[n-1]=x-y;
            stones[n-2]=0;
        }


        return stones[0];

    }
}