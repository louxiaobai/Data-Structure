package com.leedcode.ms;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/1/21-10:12 下午
 */
public class Intersection {


    /**
     * 暴力循环求解-HashSet存取值
     * 时间复杂度O(n*m)
     * 空间复杂度O(min(m,n))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j <nums2.length ; j++) {

                if (nums1[i]==nums2[j]){

                    hashSet.add(nums1[i]);
                    break;
                }
            }
        }

        int[] arr=new int[hashSet.size()];
        int index=0;
        for (Integer integer : hashSet) {
            arr[index++]=integer;
        }
        return arr;
    }

    /**
     * 使用二分查找发
     * 时间复杂读O(m+n(logm))
     * 空间复杂度O(min(m,n))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {

        Set<Integer> hashSet = new HashSet<>();

        //O(mlogm)
        Arrays.sort(nums1);

        //O(n)
        for (int i : nums2) {

            if (bianrySearch(nums1, i)){

                hashSet.add(i);
            }

        }

        int[] arr=new int[hashSet.size()];

        int index=0;

        for (Integer integer : hashSet) {
            arr[index++]=integer;
        }


        return arr;

    }


    public static boolean bianrySearch(int[] nums,int target){

         int left=0;
         int right=nums.length-1;
         while (left<=right){
             int mid=left+(right-left)/2;//找到中间点
             if (nums[mid]==target){
                 return true;
             }
             if (nums[mid]>target){
                 right=mid-1;
             }else {
                 left=mid+1;
             }
         }
         return false;
    }
    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6,7};

        System.out.println(bianrySearch(arr, 2));
    }

    /**
     * 使用hashSet
     *
     * 时间复杂读O(m+n)
     * 空间复杂度O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2){

        //空间复杂度O(m)
        Set<Integer> hashSet = new HashSet<>();//存储nums1的全部不重复数据

        Set<Integer> hashSet2 = new HashSet<>();//存储不相同的公共部分


        for (int i : nums1) {//时间复杂度O(m)
            hashSet.add(i);
        }

        //O(n)
        for (int i : nums2) {
            //时间复杂度O(1)
            if (hashSet.contains(i)){
                hashSet2.add(i);
            }

        }

        int[] arr=new int[hashSet2.size()];

        int index=0;

        for (Integer integer : hashSet2) {
            arr[index++]=integer;
        }


        return arr;


    }




}