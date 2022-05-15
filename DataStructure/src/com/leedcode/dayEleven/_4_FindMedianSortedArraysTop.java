package com.leedcode.dayEleven;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lqw
 * @date 2022/4/19-11:51 下午
 */
public class _4_FindMedianSortedArraysTop {


    /**
     * 二分查找的方式 进行求解
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m=nums1.length;

        int n=nums2.length;

        int leftK=(m+n+1)/2;//表示第leftK个元素- 表示的是长度 下标从1开始

        int rightK=(m+n+2)/2;//表示第rightK个元素- 表示的是长度,下标是从1进行开始的

        //进行偶数和技术位次的计算,如果是技术则会计算两次 相同的值

        int low=getKth(nums1, nums2, leftK);

        int upper=getKth(nums1, nums2, rightK);


        return  (low+upper)*0.5;



    }


    public int getKth(int[] num1,int[] num2,int k){

        //k表示的是长度
        int len1=num1.length;
        int len2=num2.length;

        int i=0;
        int j=0;

        while (true){
            if (i>=len1) return num2[j+k-1];
            if (j>=len2) return num1[i+k-1];
            if (k==1) return Math.min(num1[i],num2[j]);
            int newI=Math.min(i+k/2, len1)-1;
            int newJ=Math.min(j+k/2, len2)-1;
            if (num1[newI]<num2[newJ]){
                k=k-(newI-i+1);
                i=newI+1;
            }else {
                k=k-(newJ-j+1);
                j=newJ+1;
            }

        }
    }

    /**
     * 使用归并排序方法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {


        int m=nums1.length;

        int n=nums2.length;

        //不用创建临时数组

        int len=m+n;

        int low=-1;
        int upper=-1;

        int index1=0;
        int index2=0;

        for (int i=0;i<=len/2;i++){

            low=upper;

            if (index1<m&&(index2>=n||nums1[index1]<nums2[index2])){
                upper=nums1[index1++];
            }else {
                upper=nums2[index2++];
            }
        }

        return len%2==0?(low+upper)*0.5:upper;

    }
    /**
     * 使用排序数组 -创建一个大数组 进行存储 两个小数组 然后将大数组进行排序
     * 如果数组为偶数 则 返回 (arr[length/2]+arr[length/2-1])*0.5
     * 如果数组为奇数 则 返回 arr[length/2]
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {


        int[] arr=new int[nums1.length+nums2.length];

        int index1=0;

        int index2=0;

        int i=0;
        while (index1<nums1.length||index2<nums2.length){

            int num=index1<nums1.length?nums1[index1++]:nums2[index2++];

            arr[i++]=num;

        }
        Arrays.sort(arr);
        return arr.length%2==0?(arr[arr.length/2]+arr[arr.length/2-1])*0.5:arr[arr.length/2];
    }
    /**
     * 使用堆进行求解--大根堆存小数据,小根堆存大数据
     * 不如何题意
     * 时间复杂度:(m+n)log(m+n)
     * 空间复杂度:O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        //创建一个大根堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((n1,n2)->(n2-n1));
        //创建一个小根堆--java内置默认为小根堆
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();


        int index1=0;
        int index2=0;

        while (index1<nums1.length||index2<nums2.length){

            int num=index1<nums1.length?nums1[index1++]:nums2[index2++];

            if (maxHeap.isEmpty()){

                maxHeap.add(num);
                continue;
            }

            //大数存储在小根堆中,小数存储在大根堆中
            if (num>maxHeap.peek()){

                minHeap.add(num);
            }else {
                maxHeap.add(num);
            }

            //如果堆不平衡则进行调整两个堆

            if (maxHeap.size()>minHeap.size()+1){

                minHeap.add(maxHeap.remove());

            }

            if (minHeap.size()>maxHeap.size()){

                maxHeap.add(minHeap.remove());

            }

        }

        if (maxHeap.size()==minHeap.size()){

            return (maxHeap.peek()+minHeap.peek())*0.5;
        }else {

            return maxHeap.peek();
        }


    }

}