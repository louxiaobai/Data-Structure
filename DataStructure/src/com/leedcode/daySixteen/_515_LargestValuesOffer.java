package com.leedcode.daySixteen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/14-4:52 下午
 */
public class _515_LargestValuesOffer {


    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {


        List<Integer> res=new ArrayList<>();

        //进行特殊判断

        if (root==null) return res;

        if (root.left==null&&root.right==null){
            res.add(root.data);

            return res;
        }


        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            //得到每层的个数
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                max=Math.max(max, curr.data);
                if (curr.left!=null) queue.offer(curr.left);
                if (curr.right!=null) queue.offer(curr.right);
            }

            res.add(max);


        }

        return res;

    }

}