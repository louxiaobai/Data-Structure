package com.leedcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lqw
 * @date 2021/9/23-11:10 ÏÂÎç
 */
public class CQueue {
    Deque<Integer> stack1=null;
    Deque<Integer> stack2=null;
    public CQueue(){
        this.stack1=new ArrayDeque<Integer>() ;
        this.stack2=new ArrayDeque<Integer>() ;
    }

    public  void appendTail(int value){


        while(!stack2.isEmpty()){

            stack1.push(stack2.pop());
        }
        stack1.push(value);

        }



    public int deleteHead(){

        while (!stack1.isEmpty()){

            stack2.push(stack1.pop());

        }


        if (stack2.isEmpty()){

            return -1;
        }

        return stack2.pop();





    }





}