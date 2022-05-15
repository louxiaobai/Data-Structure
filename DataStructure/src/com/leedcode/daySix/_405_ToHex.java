package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/14-3:52 下午
 */
public class _405_ToHex {

    /**
     *思路:二进制中 4位 对应一个 16进制,从 低4位进行比较 &15得到对应的 16进制 知道num==0；
     * 时间复杂度:O(1)
     * 空间复杂度O(1)
     * @param num
     * @return
     */
    public String toHex(int num) {

        //负数在计算机中是以原码的形式进行存在的

        if (num==0) return "0";

        char[] chars=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res="";
        while (num!=0){
            int temp=num&15;
            res=chars[temp]+res;
            num=num>>4;

        }
        return res;
    }
}