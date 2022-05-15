package com.leedcode.daySixteen;

/**
 * @author lqw
 * @date 2022/5/15-12:02 下午
 */
public class _101_IsSymmetricOffer {


    /**
     * 一般都可以使用递归进行解决
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (root==null) return true;

        return isTrue(root.left, root.right);



    }

    public boolean isTrue(TreeNode t1,TreeNode t2){

        if (t1==null&&t2==null) return true;

        if (t1==null^t2==null) return false;

        if (t1.data!=t2.data) return false;

        return isTrue(t1.left, t2.right)&&isTrue(t1.right, t2.left);

    }
}