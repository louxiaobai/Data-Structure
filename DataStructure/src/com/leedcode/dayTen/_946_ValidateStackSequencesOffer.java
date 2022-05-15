package com.leedcode.dayTen;

import java.util.ArrayDeque;

/**
 * @author lqw
 * @date 2022/4/11-3:22 下午
 */
public class _946_ValidateStackSequencesOffer {

    /**
     * 使用单调栈进行求解
     * 思路:创建一个队列进行push和pop遍历 两个数组,首先判断 stack中的数是否在popped中如果在则进行弹出
     * 如果不在 对 pushed判断是否 数组越界 如果不越界 则进行存储,pushed数组存储完毕 则一依次 按照 popped的元素进行
     * 弹出栈,最后判断栈是否为空,如果为空则说明 为ture
     * 时间复杂度:O(m+n)
     * 空间复杂度:O(m+n)
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

         //创建一个队列

        ArrayDeque<Integer> stack=new ArrayDeque<>();


        int m=0;

        int n=0;


        while (m<pushed.length||n<popped.length){//

            //进行判断stack中是否有poped中的元素

            if (!stack.isEmpty()&&stack.peek()==popped[n]){

                stack.pop();
                n++;
            }else if (m<pushed.length){
                stack.push(pushed[m]);
                m++;
            }else {

                n++;
            }
        }

        return stack.isEmpty();
    }

}