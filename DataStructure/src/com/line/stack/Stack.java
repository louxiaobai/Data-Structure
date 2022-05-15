package com.line.stack;

/**
 * @author lqw
 * @date 2021/9/19-11:40 ����
 */
public interface Stack<E> {


    /**
     * �鿴ջ�е�Ԫ�ظ���
     * @return
     */
    int getSize();

    /**
     * �����ж�ջ�е�Ԫ���Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

    /**
     * ��ջ
     * ��Ԫ��ѹ��ջ��
     * @param e
     */
    void push(E e);

    /**
     * ��ջ
     * ��Ԫ�ص���ջ
     * @param
     * @return
     */
    E pop();

    /**
     * ��ѯջ����Ԫ��
     * @return
     */
    E peak();





}
