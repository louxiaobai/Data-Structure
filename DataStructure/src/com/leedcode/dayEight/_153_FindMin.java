package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/1-10:50 上午
 */
public class _153_FindMin {


    public static void main(String[] args) {
        int[] arr=new int[]{3,4,5,1,2};

        System.out.println(findMin(arr));
    }

    /**
     * 二分查找:进行判断 mid所指向的元素的大小和right所指向的元素的大小做对比,如果nums[mid]>nums[right]--说明此时最小元素一定在右边
     * 相反会在mid的左边
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {

        if (nums==null||nums.length==0) return -1;

        int left=0;

        int right=nums.length-1;

        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[right]){//说明此时最小值一定在mid的右边
                  left=mid;
            }else{//说明此时最小值一定在mid的左边
                right=mid;
            }
        }

        return nums[left];

    }

}