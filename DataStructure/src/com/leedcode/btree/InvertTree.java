package com.leedcode.btree;

/**
 * @author lqw
 * @date 2022/1/12-11:05 上午
 */
public class InvertTree {


    /**
     * 226. 翻转二叉树 --递归实现
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if(root==null) return root;

        if (root.right==null&&root.left==null){
            return root;
        }else {
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            root.left=invertTree(root.left);
            root.right=invertTree(root.right);
        }
        return root;

    }

}