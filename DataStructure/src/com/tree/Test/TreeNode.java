package com.tree.Test;

/**
 * @author lqw
 * @date 2021/12/31-9:04 上午
 */
class TreeNode<E>{

    E data;

    TreeNode<E> left;

    TreeNode<E> right;

    TreeNode(E data){
        this.data=data;
        left=right=null;
    }

}