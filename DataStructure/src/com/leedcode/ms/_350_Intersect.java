package com.leedcode.ms;


import com.leedcode.LinkedList.ListNode;

import java.util.*;

/**
 * @author lqw
 * @date 2022/1/21-11:16 下午
 */
public class _350_Intersect {

    public static void main(String[] args) {

        int[] nums1=new int[]{1,2,2,1};
        int[] nums2=new int[]{2,2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));


    }

    /**
     *双指针求解
     * 时间复杂度O(max(nlogn,mlogm,n+m))
     * 空间复杂度O(min(n,m))
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        //对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        List<Integer> list=new ArrayList<>();

        //双指针求解

        int i=0;
        int j=0;

        while (i<nums1.length&&j<nums2.length){

            if (nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }


        int[] arr=new int[list.size()];
        int index=0;
        for (Integer integer : list) {
            arr[index++]=integer;
        }

        return arr;

    }

    /**
     * 使用hashmap进行求解
     * 时间复杂度O(m+n)
     * 空间复杂度O(min(m,n))
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2){


        Map<Integer,Integer> map=new HashMap<>();


        List<Integer> list=new ArrayList<>();//存储元素

        //往map中进行存储数据-----时间复杂度O(n)
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i, 0)+1);
        }

        for (int i : nums2) {

            if (map.containsKey(i)&&map.get(i)>0){
                list.add(i);
                map.put(i, map.get(i)-1);
            }

        }

        int[] arr=new int[list.size()];

        int index=0;

        for (Integer integer : list) {

            arr[index++]=integer;
        }


        return  arr;


    }


}