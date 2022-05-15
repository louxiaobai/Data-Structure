package com.line.stack;


import java.util.ArrayList;

/**
 * @author lqw
 * @date 2021/9/19-2:55 ÏÂÎç
 */
public class DynamicArrayStack<E> implements Stack<E> {

    private ArrayList<E> data;

    public  DynamicArrayStack(int capacity){

        this.data=new ArrayList<E>(capacity);

    }


    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {

          data.add(e);

    }

    @Override
    public E pop() {
        return data.remove(data.size()-1);
    }

    @Override
    public E peak() {

        return data.get(data.size()-1);
    }
}