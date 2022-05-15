package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/2/10-2:20 下午
 */
public class _18_IsPalindromeOffer {


    /**
     * 使用对撞指针进行判断
     * 时间复杂度:O(n/2)
     * 空间复杂度:O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        int left=0;
        int right=s.length()-1;

        while (left<right){
            //忽略字符串左边无效字符
            while (left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            //忽略字符串右边无效字符
            while (left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left<right&&Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }else {

                left++;

                right--;

            }
        }
        return true;
    }
}