package com.highlevel.heap;

import java.util.ArrayList;

/**
 * @author lqw
 * @date 2022/1/14-11:13 上午
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap() {

        this.data = new ArrayList<>();
    }

//    返回堆中的元素个数

    public int size(){

        return data.size();
    }

//    判断堆是否为空
    public boolean isEmpty(){

        return data.isEmpty();

    }
//    返回一个索引所表示的元素的左孩子节点的索引

    public int leftChile(int index){

        return index*2+1;

    }

//    返回一个索引所表示的元素的右孩子节点的索引
    public int rightChile(int index){

        return index*2+2;

    }
// 返回一个索引所表示的元素的父亲节点的索引

    public int parent(int index){

        if (index==0){

            throw new IllegalArgumentException("index-0 dose not have parent");
        }
        return (index-1)/2;

    }

    public void add(E e){

//       先将元素插入到数组的最后





    }










}