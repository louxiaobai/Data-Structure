package com.leedcode.dayNine;




import java.util.HashMap;
import java.util.Map;


/**
 * @author lqw
 * @date 2022/4/6-11:53 上午
 */
public class _136_SingleNumber {


    /**
     * 使用hash查找:使用hashMap进行存储数据,键为数组中的数据,值初始化为1,然后再次遍历到相同的数据再+1
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

         if (nums.length==1) return 1;

         Map<Integer,Integer> hashMap=new HashMap<>();


         //对数据进行存储

        for (int num : nums) {

            if (hashMap.containsKey(num)){

                hashMap.put(num, hashMap.get(num)+1);
            }else {

                hashMap.put(num, 1);
            }

        }

        //然后再次遍历数组查看 hashmap 值为1的 元素

        for (int num : nums) {


            if (hashMap.get(num)==1) return num;

        }

        return -1;

    }
    /**
     * 使用二进制的进行求解:因为相同的数字进行异或一定为0
     * 时间复杂度:O(n)
     * 空间复杂:O(1)
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {

        int ans=nums[0];

        for (int i = 1; i < nums.length; i++) {

            ans=ans^nums[i];

        }
        return ans;

    }

}