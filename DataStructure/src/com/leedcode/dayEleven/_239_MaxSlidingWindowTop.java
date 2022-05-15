package com.leedcode.dayEleven;

import java.util.*;

/**
 * @author lqw
 * @date 2022/4/22-10:43 上午
 */
public class _239_MaxSlidingWindowTop {


    public static void main(String[] args) {

        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};

        maxSlidingWindow(nums,3);

    }


    /**
     * 使用双端队列进行求解
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque=new LinkedList<>();//创建一个双端队列


        int[] res=new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {

            //1.要保证队列中最多只有k个值

            while (!deque.isEmpty()&&deque.peek()<=i-k){//如果队首的下标小于或者等于i-k说明不在该窗口内

                deque.poll();//将队尾的元素进行弹出

            }
            //2.进行判断要插入的元素和队首的元素进行比较 如果插入元素 大于 对首元素 则进行删除操作

            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){

                deque.pollLast();//将队首的元素进行弹出

            }
            deque.add(i);
            if (i>=k-1) res[i-k+1]=nums[deque.peek()];
        }
        return res;
    }
    /**
     * 大顶堆--进行求解
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {

        //1.进行特殊判断
        if (nums.length == 1) return new int[]{nums[0]};

        //创建一个数组用来保存每个滑动窗口的最大值

        int[] ans=new int[nums.length-k+1];


        //创建一个大顶堆 存储 数据 和对应的 索引
        //先使用数据进行比较大小,如果数据相同的话则按照数组的下标进行比较
        //如果数据相同按照 下标 从大到小排序 是为了 减少 堆进行删除的次数
        PriorityQueue<int[]> pq=new PriorityQueue<>((n1,n2)->(n2[0]!=n1[0]? n2[0]-n1[0]:n2[1]-n1[1]));

        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i],i});
        }
        ans[0]=pq.peek()[0];
        //从 k 开始走 每走一个元素 都 会产生一个滑动窗口,将对应的值进行保存即可
        for (int i = k; i <nums.length ; i++) {
            pq.add(new int[]{nums[i], i});
            //进行判断是否要进行删除堆顶的元素
            while (pq.peek()[1]<=i-k){//说明需要进行删除堆顶的元素--当前下标小于等于 i-k
                pq.remove();
            }
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;


    }


}