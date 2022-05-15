package com.line.quequ;

/**
 * @author lqw
 * @date 2021/9/23-6:43 下午
 */
public interface Quequ<E> {

    /**
     * 查看队列中的的元素个数
     * @return
     */
    int getSize();

    /**
     * 用来判断队列中的元素是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 查看队首的元素
     * @return
     */
    E getFront();

}