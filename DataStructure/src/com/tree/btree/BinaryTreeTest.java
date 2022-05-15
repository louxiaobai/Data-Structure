package com.tree.btree;



import sun.jvm.hotspot.runtime.linux.LinuxSignals;

import java.util.*;

/**
 * @author lqw
 * @date 2021/12/31-10:54 上午
 */
public class BinaryTreeTest {


    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(23);
        TreeNode<Integer> node1 = new TreeNode<>(34);
        TreeNode<Integer> node2 = new TreeNode<>(21);
        TreeNode<Integer> node3 = new TreeNode<>(99);
        TreeNode<Integer> node4 = new TreeNode<>(77);
        TreeNode<Integer> node5 = new TreeNode<>(90);
        TreeNode<Integer> node6 = new TreeNode<>(45);
        TreeNode<Integer> node7 = new TreeNode<>(60);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node3.right=node5;
        node3.left=node4;
        node2.left=node6;
        node2.right=node7;

        System.out.println(preOrderR(root ));



    }

    /**
     * 前序遍历--实现树的前序遍历
     * 时间复杂度0(n),n表示二叉树的节点个数
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public static ArrayList<Integer> preOrder(TreeNode<Integer> root){

        ArrayList<Integer> res = new ArrayList<Integer>();

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<Integer> curr = stack.pop();
            res.add(curr.data);
            if (curr.right!=null) stack.push(curr.right);
            if (curr.left!=null) stack.push(curr.left);

        }
        return res;
    }


    /**
     * 递归实现前序遍历
     * 时间复杂度O(n)
     * 空间复杂度O(n),
     * @param root
     * @return
     */
    public static List<Integer> preOrderR(TreeNode<Integer> root){

        List<Integer> res= new ArrayList<>();

        preOrderR(root, res);

        return res;


    }
    /**
     * 递归实现前序遍历
     * 时间复杂度O(n)
     * 空间复杂度最坏O(n),最好 O(logn )
     * @param root
     * @return
     */
    public static void preOrderR(TreeNode<Integer> root,List<Integer> res){

        //递归的终止条件
        if (root==null) return ;

        //先进行访问当前节点

        res.add(root.data);

        //在前序遍历左子树

        preOrderR(root.left,res);

        //最后前序遍历右子树

        preOrderR(root.right,res);
    }


    /**
     * 中序遍历--实现树的中序遍历
     * 时间复杂度0(n),n表示二叉树的节点个数
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public static ArrayList<Integer> inOrder(TreeNode<Integer> root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root==null) return res;
        //创建一个栈
        Stack<TreeNode<Integer>> stack= new Stack<>();
        TreeNode<Integer> curr=root;
        while(curr!=null||!stack.isEmpty()){
            //先把全部的左子树存储到栈中
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            TreeNode<Integer> node=stack.pop();
            res.add(node.data);
            curr= node.right;
        }
        return res;
    }

    /**
     * 递归实现中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inOrderR(TreeNode<Integer> root){


        List<Integer> res=new ArrayList<>();

        inOrderR(root,res);

        return res;

    }

    public static void inOrderR(TreeNode<Integer> root,List<Integer> res){

        //递归的终止条件
        if (res==null) return;

        //进行递归遍历左子树

        inOrderR(root.left,res);

        //进行存储根节点

        res.add(root.data);

        //进行递归遍历右紫薯

        inOrderR(root.right,res);


    }


    /**
     * 后序遍历-实现树的中后续遍历
     * 时间复杂度0(n),n表示二叉树的节点个数
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode<Integer> root){

        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<Integer> curr = stack.pop();
            res.addFirst(curr.data);//头插发
            if (curr.left!=null) stack.push(curr.left);
            if (curr.right!=null) stack.push(curr.right);
        }

        return res;


    }

    /**
     * 递归实现树的后序遍历
     * @param root
     * @return
     */

    public static List<Integer> postOrderR(TreeNode<Integer> root){

        List<Integer> res=new ArrayList<>();

        postOrderR(root, res);

        return res;
    }

    public static void postOrderR(TreeNode<Integer> root,List<Integer> res){



        //进行判断递归的终止条件

        if (root==null) return;

        //进行递归遍历树的左子树

        postOrderR(root.left, res);

        //进行递归的遍历 树的右子树
        postOrderR(root.right, res);
        //存储树的根节点
        res.add(root.data);


    }


    /**
     * 层序遍历--实现树的层序遍历
     * 时间复杂度0(n),n表示二叉树的节点个数
     * 空间复杂度O(n)
     * @param root
     * @return
     */

    public static List<Integer> levelOrder(TreeNode<Integer> root){

        List<Integer> res = new ArrayList<>();

        if (root==null) return res;

        //创建一个队列

       Queue<TreeNode<Integer>> qeue = new LinkedList<>();

       qeue.offer(root);

       while (!qeue.isEmpty()){

           TreeNode<Integer> curr = qeue.poll();
           res.add(curr.data);
           //将遍历处理的节点的左右子节点入队,等待后续的处理
           if (curr.left!=null) qeue.offer(curr.left);
           if (curr.right!=null) qeue.offer(curr.right);
       }
       return res;
    }

    /**
     * 层序遍历--实现树的层序遍历--分层进行存储数据
     * 时间复杂度0(n),n表示二叉树的节点个数
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder02(TreeNode<Integer> root){


        List<List<Integer>> res = new ArrayList<>();


        if (root==null) return res;

        //创建一个队列
        Queue<TreeNode<Integer>> qeue = new LinkedList<>();
        qeue.offer(root);

        while (!qeue.isEmpty()){

            int size=qeue.size();//得到该层树的数目

            List<Integer> levelNodes = new ArrayList<>();

            for (int i=0;i<size;i++){

                TreeNode<Integer> curr = qeue.poll();
                levelNodes.add(curr.data);
                //将遍历处理的节点的左右子节点入队,等待后续的处理
                if (curr.left!=null) qeue.offer(curr.left);
                if (curr.right!=null) qeue.offer(curr.right);

            }
            //将同一层的数据进行存储
            res.add(levelNodes);
        }
        return res;
    }


}