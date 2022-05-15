package com.leedcode.btree;

/**
 * @author lqw
 * @date 2021/12/31-9:04 上午
 */
class TreeNode<E>{

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int val) {
           this.val = val;
           left=right=null;
      }

}