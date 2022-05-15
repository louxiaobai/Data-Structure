package com.line.stack;

/**
 * @author lqw
 * @date 2021/9/19-11:40 上午
 */
public interface Stack<E> {


    /**
     * 查看栈中的元素个数
     * @return
     */
    int getSize();

    /**
     * 用来判断栈中的元素是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 进栈
     * 将元素压如栈中
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * 将元素弹出栈
     * @param
     * @return
     */
    E pop();

    /**
     * 查询栈顶的元素
     * @return
     */
    E peak();





}
