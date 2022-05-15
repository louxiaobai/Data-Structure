package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/5-11:01 下午
 */
public class _38_CountAndSay {

    /**
     * 思路:直接模拟发---按照题意一步一步的去模拟
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        //当前描述前一个
        StringBuilder curr=new StringBuilder("1");//最开始描述的值为1

        StringBuilder prev;

        for (int i = 1; i < n; i++) {
            prev=curr;
            curr=new StringBuilder();
            char say=prev.charAt(0);//先拿到这一轮次的第一个值
            int count=1;//计数器

            for (int j = 1; j < prev.length(); j++) {

                 if (say==prev.charAt(j)){
                     count++;//如果前一个值和当前值相等则计数器+1
                 }else{//如果当前值和前一个值不相等进行到curr中
                     curr.append(count).append(say);
                     say=prev.charAt(j);
                     count=1;
                 }

            }
            //循环结束 则把最后一个值保存上
            curr.append(count).append(say);
        }
        return curr.toString();


    }
}