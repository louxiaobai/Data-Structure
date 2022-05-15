package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/13-11:07 下午
 */
public class _260_SingleNumber {

    /**
     * 思路:先将数组中的全部数进行异或操作得到a^b,然后取道a^b中的最后以为1,
     * 在次遍历数组可以将数组中的数据划分为两个领域的数据,然后进行异或操作
     * 即可得到 a 和 b
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {

        if (nums.length == 2) return new int[]{nums[0], nums[1]};
        int res = 0;
        for (int num : nums) res^=num;//可以得到 a^b 但是不确定 a 和b 的具体数值
        int k=res&(-res);//去到res中最后一个1
        //在次对数组里面的内容进行异或操作
        int[] arr=new int[2];
        for (int num : nums) {
            if ((num&k)!=0){
                arr[0]^=num;
            }else {
                arr[1]^=num;
            }
        }
        return arr;
    }
}