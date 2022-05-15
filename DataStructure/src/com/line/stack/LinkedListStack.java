package com.line.stack;

import com.line.linkedlist.LinkedList;

/**
 * @author lqw
 * @date 2021/9/19-3:19 ÏÂÎç
 */
public class LinkedListStack<E> implements Stack<E> {


    private LinkedList<E> linkedList;

    public LinkedListStack() {


        linkedList = new LinkedList<E>();

    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {

        linkedList.addFirst(e);

    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peak() {
        return linkedList.get(0);
    }


    @Override
    public String toString() {


        StringBuilder sb=new StringBuilder();

        sb.append("Stack:[");

        for (int i = linkedList.getSize(); i >=0 ; i--) {

            sb.append(linkedList.get(i));
            if (i!=0){

                sb.append(",");

            }

        }

        sb.append("] top");

        return sb.toString();

    }
}