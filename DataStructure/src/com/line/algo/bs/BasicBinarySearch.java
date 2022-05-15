package com.line.algo.bs;

/**基础版本的二分查找
 * @author lqw
 * @date 2021/10/10-9:39 上午
 */
public class BasicBinarySearch {

    public static void main(String[] args) {
        int[] data={5,3,1};
        System.out.println(contain02(data, 0,data.length-1,1));
    }
    /**
     * 实现基础的二分查找--迭代法
     * @param data
     * @param target
     * @return
     */
    public static boolean contain(int[] data,int target){

        if (data==null||data.length==0) return false;
        int left=0;
        int right=data.length-1;
        while (left<=right){//进行查找的条件
            //int mid=(left+right)/2;//这样取中间值可能会溢出--改为下面的求中间值的方法
            int mid=left+((right-left)>>1);//位运算的优先级较低---取左边

            if (target==data[mid]){//找到元素返回true
                return true;
            }else  if (target<data[mid]){//中间元素比目标元素大 则下一次的搜索空间为[left....mid-1]
                right=mid-1;
            }else{//中间元素比目标元素小 则下一次的搜索空间为[mind+1.....right]
                left=mid+1;
            }
        }
        return false;
    }


    /**
     * 实现基础的二分查找--递归
     * @param data
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static boolean contain02(int[] data,int left,int right,int target){

        if (left>right)  return false;//递归结束条件

        int mid=left+(right-left)/2;
        if (data[mid]==target){

            return true;

        } else if (data[mid]>target){


            return contain02(data, left, mid-1, target);

        }else{

            return contain02(data, mid+1, right, target);

        }

    }
}