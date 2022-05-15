package com.highlevel.set;

import com.line.linkedlist.LinkedList;

/**
 * @author lqw
 * @date 2022/1/15-10:58 上午
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> data;

    public LinkedListSet(LinkedList<E> data) {
        this.data = new LinkedList<>();
    }

    @Override
    public int size() {

        return data.getSize();

    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E e) {

        if (!data.contains(e)){

            data.addFirst(e);
        }

    }

    @Override
    public void remove(E e) {

       data.removeElement(e);



    }

    @Override
    public boolean contains(E e) {

        return data.contains(e);
    }



}