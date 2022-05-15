package com.highlevel.set;

import java.util.ArrayList;

/**
 * @author lqw
 * @date 2022/1/15-10:53 上午
 */
public class ArraySet<E> implements Set<E> {


    private ArrayList<E> data;

    public ArraySet(ArrayList<E> data) {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E e) {

        if (!data.contains(e)){

            data.add(e);

        }

    }

    @Override
    public void remove(E e) {

        data.remove(e);

    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    @Override
    public String toString() {
        return "ArraySet{" +
                "data=" + data +
                '}';
    }
}