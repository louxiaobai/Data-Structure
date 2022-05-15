package com.highlevel.set;

/**
 * @author lqw
 * @date 2022/1/15-10:48 上午
 */
public interface  Set<E> {

    int size();

    boolean isEmpty();

    void add(E e);

    void remove(E e);

    boolean contains(E e);

}