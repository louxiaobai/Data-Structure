package com.leedcode.daySixteen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/13-11:57 上午
 */
public class _102_LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {


        //创建一个了链表存储各层的数据

        LinkedList<List<Integer>> res = new LinkedList<>();

        //进行特殊判断
        if(root==null) return res;

        //创建一个队列 对树进行操作

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){

            //创建一个链表存储该层的数据

            List<Integer> list=new ArrayList<>();

            //得到该层的节点个数

            int size=queue.size();

            for(int i=0;i<size;i++){

                TreeNode<Integer> curr= queue.poll();

                list.add(curr.data);

                if(curr.left!=null) queue.offer(curr.left);

                if(curr.right!=null) queue.offer(curr.right);

            }

            res.addFirst(list);


        }


        return res;


    }
}