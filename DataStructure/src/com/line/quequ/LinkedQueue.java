package com.line.quequ;

import com.line.linkedlist.LinkedList;

/**
 * @author lqw
 * @date 2021/9/23-7:14 ÏÂÎç
 */
public class LinkedQueue<E> implements Quequ<E>{

    private LinkedList<E> data;

    public LinkedQueue(){

        data=new LinkedList<E>();
    }


    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {

        data.addLast(e);

    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }
    @Override
    public String toString() {

        StringBuilder res=new StringBuilder();
        res.append("Quueu:¶ÓÊ×[");

        for (int i = 0; i <data.getSize() ; i++) {

            res.append(data.get(i));

            if (i!=data.getSize()-1){

                res.append(",");
            }

        }

        res.append("]");

        return res.toString();

    }
}