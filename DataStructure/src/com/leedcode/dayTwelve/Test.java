package com.leedcode.dayTwelve;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author lqw
 * @date 2022/4/23-10:42 下午
 */
public class Test {

    public static void main(String[] args) {


        System.out.println(removeKdigits(

                "1432219", 3));
    }

    /**
     * 一
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {

        //1.进行特殊判断
        if (num.length()==k) return "0";
        int remain=num.length()-k;
        //创建一个双端队列
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        //对元素进行遍历
        for (int i = 0; i < num.length(); i++) {
            int x=num.charAt(i)-'0';//得到数字
            //如果出现栈顶的元素大于当前元素则进行删除
            while (!stack.isEmpty()&&k>0&&stack.peek()>x){
                stack.pop();
                k--;
            }
            stack.push(x);

        }
        //可能出现123456 这种数据 导致 没有元素被删除 此时 只需要截取 前 num.length-k个数即可
        //进行保存 num.length-k个数
        StringBuilder res=new StringBuilder();
        while (remain>0){

            res.append(stack.pollLast());

            remain--;
        }


        //进行删除前导零

        while (res.length()>1&&res.charAt(0)=='0'){

            res.deleteCharAt(0);


        }
        return res.toString();
    }
}