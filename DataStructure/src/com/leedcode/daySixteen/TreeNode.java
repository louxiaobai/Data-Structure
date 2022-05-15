package com.leedcode.daySixteen;

/**
 * @author lqw
 * @date 2022/5/12-3:18 下午
 */


class TreeNode<E>{

    int data;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode(int data){
        this.data=data;
        left=right=null;
    }
}