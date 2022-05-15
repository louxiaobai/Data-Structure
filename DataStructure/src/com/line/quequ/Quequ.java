package com.line.quequ;

/**
 * @author lqw
 * @date 2021/9/23-6:43 ����
 */
public interface Quequ<E> {

    /**
     * �鿴�����еĵ�Ԫ�ظ���
     * @return
     */
    int getSize();

    /**
     * �����ж϶����е�Ԫ���Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

    /**
     * ���
     * @param e
     */
    void enqueue(E e);

    /**
     * ����
     * @return
     */
    E dequeue();

    /**
     * �鿴���׵�Ԫ��
     * @return
     */
    E getFront();

}