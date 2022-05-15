package com.leedcode.daySixteen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/13-12:07 下午
 */
public class _104_MaxDepthOffer {


    /**
     * 递归方法求解树的高度问题--后序遍历
     * 大问题化解成小问题
     * 找出递归终止条件
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root==null) return 0;

        //大问题化解成小问题---计算左右子数的最大高度

        int left=maxDepth(root.left);

        int right=maxDepth(root.right);

        return Math.max(left, right)+1;

    }

    /**
     * 使用数的层序遍历进行求解 迭代方法
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {

        //使用层序遍历即可得到最大深度

        if(root==null) return 0;

        //创建一个队列

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);


        int res=0;

        while(!queue.isEmpty()){


            //得到该层的节点个数
            int size=queue.size();

            for(int i=0;i<size;i++){

                TreeNode curr= queue.poll();

                if(curr.left!=null) queue.offer(curr.left);

                if(curr.right!=null) queue.offer(curr.right);
            }
            res++;
        }

        return res;


    }
}