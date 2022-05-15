package com.leedcode.dayEleven;

import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/4/19-11:17 下午
 */

/**
 * 创建两个堆--大顶堆存小数据--小顶堆存大数据
 */
public class _295_MedianFinderOffer {

    private PriorityQueue<Integer> minHeap=null;//小顶d堆

    private PriorityQueue<Integer> maxHeap=null;//大顶堆

    public _295_MedianFinderOffer() {

        this.maxHeap=new PriorityQueue<>((n1,n2)->(n2-n1));//大顶堆

        this.minHeap=new PriorityQueue<>();//小顶堆

    }

    //时间复杂度:O(logn)
    public void addNum(int num) {

        if (maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }

        if (num>maxHeap.peek()){//如果传过来的值大于大顶堆的最大值则存在小顶堆中,反之则存在大顶堆中
            minHeap.add(num);
        }else {
            maxHeap.add(num);
        }

        //对堆进行调整平衡---即要保持大顶堆中的数要比小顶堆中的数多1 或者是相等

        if (maxHeap.size()>minHeap.size()+1){//如果大顶堆中的数比小顶堆中的数多2则进行调整

            minHeap.add(maxHeap.remove());

        }

        if (minHeap.size()>maxHeap.size()){//如果小顶堆中的数比大顶堆多1则进行调整

            maxHeap.add(minHeap.remove());

        }

    }
    //空间复杂度:O(1)
    public double findMedian() {

        if (maxHeap.size()==minHeap.size()){

            return (maxHeap.peek()+minHeap.peek())>>1;
        }else {

            return maxHeap.peek();

        }

    }

}