package com.leedcode.btree;

import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/1/20-11:44 上午
 */
public class MedianFinder {

    private PriorityQueue<Integer> minHeap;

    private PriorityQueue<Integer> maxHeap;


    public MedianFinder() {

        this.minHeap=new PriorityQueue<>();//初始化小顶堆

        this.maxHeap=new PriorityQueue<>((a,b)->b-a);//初始化大顶堆
    }

    public void addNum(int num) {

        //进行田间先添加大顶堆--大顶堆存放小数据
        if (maxHeap.isEmpty()){

            maxHeap.add(num);
            return;

        }

        if (num>maxHeap.peek()){

            minHeap.add(num);
        }else{

            maxHeap.add(num);
        }
        //进行数据的调整--如果 大顶堆的个数 比 小顶堆的个数多 2 个以及 以上 则对 大小顶堆进行调整
        if (maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.remove());
        }

        if (minHeap.size()>maxHeap.size()){

            maxHeap.add(minHeap.remove());
        }


    }

    public double findMedian() {

        if (maxHeap.size()>minHeap.size()) {

            return maxHeap.peek();

        }else {

            return (maxHeap.peek()+minHeap.peek())*0.5;
        }

    }

}