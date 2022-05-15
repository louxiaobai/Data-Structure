package com.tree.bst;

import javax.swing.*;

/**
 * @author lqw
 * @date 2022/1/3-11:07 上午
 */
public class BSTR<E extends Comparable<E>> {

    private class TreeNode{

            E data;
            TreeNode left;
            TreeNode right;

        public TreeNode(E data) {
            this.data = data;
        }
    }

    private TreeNode root;

    private int size;

    public BSTR() {
        this.root = null;
        this.size = 0;
    }

    public int getSize(){

        return size;
    }

    public boolean isEmpty(){

        return size==0;

    }

    /**
     * 插入操作
     * @param e
     */
    public void  add(E e) {

        //如果插入的的时候没根节点
        if (root==null){

            root=new TreeNode(e);

        }else{

            TreeNode curr=root;

            while (curr!=null){

                if (e.compareTo(curr.data)==0){

                    return;//说明这个节点在树中已经存在

                }else if (e.compareTo(curr.data)<0&&curr.left==null){//小与根节点

                    curr.left=new TreeNode(e);
                    size++;
                    return;

                }else if (e.compareTo(curr.data)>0&&curr.right==null){
                    curr.right=new TreeNode(e);
                    size++;
                    return;
                }

                if (e.compareTo(curr.data)<0){

                    curr=curr.left;
                }else {

                    curr=curr.right;

                }

                }


            }




        }


    public void useAddR(E e){
        root=addR(root, e);
    }
    /**
     * 插入操作--递归
     * @param node
     * @param e
     */
    public TreeNode addR(TreeNode node,E e){

        //1.递归终止条件
        if (node==null){
            size++;
            return new TreeNode(e);
        }
        //递归调用
        if (e.compareTo(node.data)<0){
            node.left=addR(node.left, e);
        }else {
            node.right=addR(node.right, e);
        }
        return node;
    }

    /**
     * 查询操作
     * @param target
     * @return
     */
    public boolean contains(E target){


        //递归查询
        if (findR(root,target)==null){

            return false;
        }else {

            return true;
        }

        //迭代查询
//        if (find(target)==null){
//
//            return false;
//        }else{
//
//            return true;
//        }




    }






    /**
     * 取最小值
     * @return
     */
    public E minValue(){

        if (root==null){

            throw new RuntimeException("tree is null");
        }

        //递归查询

        return minValueR(root).data;



        //迭代查询
//        TreeNode min=root;
//        while (min.left!=null){
//            min=min.left;
//        }
//        return min.data;
    }

    public TreeNode minValueR(TreeNode node){

        if (node.left==null) return null;
        return minValueR(node.left);


    }

    /**
     * 取最大值
     * @return
     */
    public E maxValue() {


        if (root==null){

            throw  new RuntimeException("tree is null");

        }
//        递归求解最大值

        return minValueR(root).data;




//        迭代求解最大值
//        TreeNode max=root;
//
//        while (max.right!=null){
//
//            max=max.right;
//        }
//
//        return max.data;

    }


    /**
     * 递归求解最大值
     * @param node
     * @return
     */
    public TreeNode maxValueR(TreeNode node){

        if (node.left==null) return node;

        return node.left;
    }

    /**
     * 删除最小值
     * @return
     */
    public E removeMin(){


        E res=minValue();

        root=maxValueR(root);

        return res;

//        if (root==null){
//            throw  new RuntimeException("tree is null");
//        }
//
//
//        TreeNode parent=null;
//        TreeNode min=root;
//
//        while (min.left!=null){
//            parent=min;
//            min=min.left;
//
//
//        }
//        if (parent==null){
//
//            root=root.right;
//
//        }else {
//
//            parent.left=min.right;
//            min.right=null;
//
//
//        }
//        size--;
//        return min.data;

    }


    /**
     * 递归删除最小值
     * @param node
     * @return
     */

    public TreeNode removeMinR(TreeNode node){

        if (node.left==null){

            TreeNode rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }

       TreeNode leftRoot=removeMinR(node.left);

        node.left=leftRoot;
        return node;

    }

    /**
     * 删除最大值
     * @return
     */
    public E removeMax(){

        if (root==null){
            throw  new RuntimeException("tree is null");
        }
        TreeNode parent=null;
        TreeNode max=root;
        while (max.right!=null){
            parent=max;
            max=max.right;
        }
        if (parent==null){
            root=root.left;
        }else {
            parent.right = max.left;
            max.right = null;
        }
        size--;
        return max.data;
    }
    /**
     * 删除任意元素
     * @param e
     */
    public void remove1(E e){

        if (root==null) return;
        TreeNode curr=root;
        TreeNode parent=null;
        while (curr!=null&&e.compareTo(curr.data)!=0){
            parent=curr;
            if (e.compareTo(curr.data)>0){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        //说明找到了 目标节点
        if (curr!=null){
            if (curr.right==null&&curr.left==null){//删除叶子节点
                if (parent==null){//删除的是根节点
                    root=null;
                }
                if (parent.left!=null) parent.left=null;
                if (parent.right!=null) parent.right=null;
            }
            if (curr.right!=null&&curr.left==null){//只有右子树

                if (parent==null){
                    root=root.right;
                }
                if (parent.left==curr){
                    parent.left=curr.right;
                    curr.right=null;
                }

                if (parent.right==curr){
                    parent.right=curr.right;
                    curr.right=null;
                }
            }
            if (curr.left!=null&&curr.right==null){//只有左子树

                if (parent==null){
                    root=root.left;
                }
                if (parent.right==curr){
                    parent.right=curr.left;
                    curr.left=null;
                }
                if (parent.left==curr){
                    parent.left=curr.left;
                    curr.left=null;
                }

            }

            if (curr.right!=null&&curr.left!=null){//左右子树都有
                TreeNode min=curr.right;
                TreeNode minParent=null;
                while (min!=null){
                    minParent=min;
                    min=min.left;
                }
                //覆盖需要删除节点的值
                curr.data=min.data;
                //删除最小值的节点
                minParent.left=null;

            }
        }else{
            return;//没有找到目标节点
        }

    }
    /**
     * 删除任意节点---减少了代码量
     * @param e
     */
    public void remove(E e){


        root=removeR(root,e);

//        if (root==null) return;
//        TreeNode curr=root;
//        TreeNode parent=null;
//        while (curr!=null&&e.compareTo(curr.data)!=0){
//            parent=curr;
//            if (e.compareTo(curr.data)>0){
//                curr=curr.right;
//            }else{
//                curr=curr.left;
//            }
//        }
//        if (curr==null) return;//说明没有找到该节点
//
//        if (curr!=null){//找到了该节点进行删除操作
//            if (curr.right!=null&&curr.left!=null){//左右子树都有
//                TreeNode min=curr.right;
//                TreeNode minParent=null;
//                while (min!=null){
//                    minParent=min;
//                    min=min.left;
//                }
//                //覆盖需要删除节点的值
//                curr.data=min.data;
//                //删除最小值的节点
//                curr=min;
//                parent=minParent;
//            }
//            //删除节点是叶子节点或者仅有一颗子树
//
//            TreeNode child;//用于存储 需要删除节点的子节点
//
//            if (curr.left!=null){
//
//                child=curr.left;
//
//                if (parent!=null) curr.left=null;
//
//            }else if (curr.right!=null){
//
//                child=curr.right;
//
//                if (parent!=null) curr.right=null;
//            }else {
//                child=null;
//            }
//            if (parent==null){
//                root=null;
//            }else if (curr==parent.left){
//
//                parent.left=child;
//
//            }else if (curr==parent.right){
//
//                parent.right=child;
//
//            }
//        }
    }

    /**
     * 递归删除节点e
     * @param node
     * @param e
     * @return
     */
    public TreeNode removeR(TreeNode node,E e) {

        if (node == null) return null;

        if (e.compareTo(node.data) < 0) {
            node.left = removeR(node.left, e);
            return node;

        }
        else if (e.compareTo(node.data) > 0) {
            node.right = removeR(node.right, e);
            return node;
        } else {//找到要删除的节点
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                TreeNode leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;

            } else {//node的left和right都不为空
                TreeNode successor = minValueR(node.right);
                successor.right = removeMinR(node.right);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                return successor;

            }

        }



    }



    /**
     * 查询某个节点
     * @param target
     * @return
     */
    public E find(E target){

        if (root==null) return null;

        TreeNode curr=root;

        while (curr!=null){

            if (target.compareTo(curr.data)==0){

                return curr.data;
            }else if (target.compareTo(curr.data)<0){

                curr=curr.left;

            }else{

                curr=curr.right;

            }

        }

        return null;




    }


    public TreeNode findR(TreeNode node,E target){

        if (node==null) return null;

        if (target.compareTo(node.data)==0){

            return node;
        }else if (target.compareTo(node.data)<0){

            return findR(node.left, target);
        }else{

            return findR(node.right, target);
        }


    }
}