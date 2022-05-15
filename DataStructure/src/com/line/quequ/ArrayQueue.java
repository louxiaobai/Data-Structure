package com.line.quequ;

import java.util.ArrayList;

/**选择左边为队尾 右边为队首
 * @author lqw
 * @date 2021/9/23-6:57 下午
 */
public class ArrayQueue<E> implements Quequ<E> {


    private ArrayList<E> data;

    public ArrayQueue(){

        data=new ArrayList<E>();

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
    public void enqueue(E e) {

        data.add(data.size(), e);

    }

    @Override
    public E dequeue() {


        return data.remove(0);
    }

    @Override
    public E getFront() {
        return data.get(0);
    }

    @Override
    public String toString() {

        StringBuilder res=new StringBuilder();
        res.append("Quueu:队首[");

        for (int i = 0; i <data.size() ; i++) {

            res.append(data.get(i));

            if (i!=data.size()-1){

                res.append(",");
            }

        }

        res.append("]");

        return res.toString();

    }
}