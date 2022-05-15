package com.leedcode.daySixteen;

/**
 * @author lqw
 * @date 2022/5/13-4:15 下午
 */
public class _110_isBalancedTop {


    int res=0;
    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;

        maxDepth(root);

        return res>1?false:true;
    }
    public int maxDepth(TreeNode root) {

        if (root==null) return 0;

        //大问题化解成小问题---计算左右子数的最大高度

        int left=maxDepth(root.left);

        int right=maxDepth(root.right);

        res=Math.max(res,Math.abs(left-right));

        return Math.max(left, right)+1;
    }
}