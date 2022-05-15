package com.leedcode.daySixteen;

/**
 * @author lqw
 * @date 2022/5/13-3:50 下午
 */
public class _543_DiameterOfBinaryTreeTop {

    int res=0;


    /**
     * 递归发求树的最大直径问题,可能不经过根节点,故需要进行求解每个节点的 左右最大深度
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {

        if (root==null) return 0;

        maxDepth(root);

        return res;

    }



    public int maxDepth(TreeNode root) {

        if (root==null) return 0;

        //大问题化解成小问题---计算左右子数的最大高度

        int left=maxDepth(root.left);

        int right=maxDepth(root.right);

        res=Math.max(res, left+right);

        return Math.max(left, right)+1;

    }




}