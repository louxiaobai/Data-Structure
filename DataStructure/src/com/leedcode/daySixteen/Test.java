package com.leedcode.daySixteen;

import java.util.*;

/**
 * @author lqw
 * @date 2022/5/12-3:17 下午
 */
public class Test {


    /**
     * 树的前序遍历--中左右
     *
     * @param treeNode
     */
    public  void  preOrderR(TreeNode<Integer> treeNode, ArrayList<Integer> res){
        if (treeNode==null) return;
        //遍历得到树的中节点的值
        res.add(treeNode.data);
        //进行遍历左子树
        preOrderR(treeNode.left, res);
        //进行遍历右子树
        preOrderR(treeNode.right, res);

    }

    /**
     * 树的中序遍历-左中右
     * @param treeNode
     * @param res
     */
    public void inOrderR(TreeNode<Integer> treeNode,ArrayList<Integer> res){

        if (treeNode==null) return;

        //遍历树的中树

        inOrderR(treeNode.left, res);

        //存储树的左子树的值

        res.add(treeNode.data);

        //遍历树的右子树
    }

    /**
     * 树的后序遍历--左右中
     * @param treeNode
     * @param res
     */
    public void postOrderR(TreeNode<Integer> treeNode,ArrayList<Integer> res){
        if (treeNode==null) return;
        //遍历左子树
        postOrderR(treeNode.left, res);
        //遍历右子树
        postOrderR(treeNode.right, res);
        res.add(treeNode.data);

    }

    /**
     * 树的前序遍历-迭代方式
     * @param root
     */
    public List<Integer> preOrder(TreeNode<Integer> root){
        ArrayList<Integer> res=new ArrayList<>();
        //创建一个栈进行操作树的前序遍历
        ArrayDeque<TreeNode<Integer>> stack=new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //得到当前的节点
            TreeNode<Integer> curr = stack.pop();
            res.add(curr.data);
            if (curr.right!=null) stack.push(curr.right);
            if (curr.left!=null) stack.push(curr.left);
        }

        return res;
    }

    /**
     * 树的中序遍历
     * @param root
     */
    public void inOder(TreeNode<Integer> root){

        ArrayList<Integer> res=new ArrayList<>();

        //创建一个栈进行对树的操作
        ArrayDeque<TreeNode<Integer>> stack=new ArrayDeque<>();
        TreeNode<Integer> curr=root;
        while (curr!=null||!stack.isEmpty()){
            //先把左子树存储到栈中
            while (curr.left!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //将最后一个左子树进行弹出
            TreeNode<Integer> node = stack.pop();
            res.add(node.data);
            curr=node.right;

        }
    }

    /**
     * 树的后续遍历--根据前序遍历进行更改
     */
    public List<Integer> postOrder(TreeNode<Integer> root){


        //主要实现头查法
        LinkedList<Integer> res=new LinkedList<>();

        //创建一个栈进行对树的操作

        ArrayDeque<TreeNode<Integer>> stack=new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode<Integer> curr = stack.pop();

            res.addFirst(curr.data);

            if (root.left!=null) stack.push(root.left);

            if (root.right!=null) stack.push(root.right);

        }

        return res;

    }


    /**
     * 层序遍历--保存每一个节点的值
     * @param root
     * @return
     */
    public List<Integer> levelOrder(TreeNode<Integer> root){

        List<Integer> res=new ArrayList<>();

        Queue<TreeNode<Integer>> queue=new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            TreeNode<Integer> curr = queue.poll();//先进先出--出队列

            res.add(curr.data);

            //层序遍历从左往右进行遍历
            if (curr.left!=null) queue.offer(curr.left);

            if (curr.right!=null) queue.offer(curr.right);

        }

        return res;



    }




    public List<List<Integer>> levelOrder2(TreeNode<Integer> root){

        //创建链表进行存储每一层的节点数据

        List<List<Integer>> res=new ArrayList<>();

        //创建一个队列进行对树的操作

        Queue<TreeNode<Integer>> queue=new LinkedList<>();


        queue.offer(root);

        while (!queue.isEmpty()){

            //按照层进行存储数据

            List<Integer> list=new ArrayList<>();

            //得到该层的数据的个数

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode<Integer> curr = queue.poll();

                list.add(curr.data);

                if (curr.left!=null) queue.offer(curr.left);

                if (curr.right!=null) queue.offer(curr.right);

            }

            res.add(list);

        }

        return res;

    }






}