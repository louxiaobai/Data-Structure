package com.leedcode.daySixteen;

import java.util.ArrayDeque;

/**
 * @author lqw
 * @date 2022/5/15-11:11 上午
 */
public class _100_IsSameTree {


    /**
     * 递归求解
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p==null&&q==null) return true;

        if (p==null||q==null) return false;

        if (q.data!=p.data) return false;


        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);

    }


    /**
     * 使用前序遍历继续求解
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {

        if (p==null&&q==null) return true;

        //创建一个栈进行操作树

        ArrayDeque<TreeNode> stack1=new ArrayDeque<>();

        ArrayDeque<TreeNode> stack2=new ArrayDeque<>();

        stack1.push(p);

        stack2.push(q);


        while (!stack1.isEmpty()&&stack2.isEmpty()){


            TreeNode currP = stack1.pop();

            TreeNode currQ = stack2.pop();

            if (currP.data!=currQ.data) return false;


            //进行判断-- 如果有一个为空 则就返回false
            if (currP.left==null^currQ.left==null) return false;

            if (currP.right==null^currQ.right==null) return false;



            if (currP.right!=null) stack1.push(currP.right);

            if (currP.left!=null) stack1.push(currP.left);

            if (currQ.right!=null) stack2.push(currQ.right);

            if (currQ.left!=null) stack2.push(currQ.left);


        }

        return stack1.isEmpty()&&stack2.isEmpty();

    }

}