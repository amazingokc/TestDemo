package com.example.testdemo.tree;

/**
 * Author:xiaoguoqing
 * Time:2020/7/28   16:55
 * Des:
 */
public class TreeNode {

    // 左节点(儿子)
    private TreeNode lefTreeNode;

    // 右节点(儿子)
    private TreeNode rightNode;

    // 数据
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLefTreeNode() {
        return lefTreeNode;
    }

    public void setLefTreeNode(TreeNode lefTreeNode) {
        this.lefTreeNode = lefTreeNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "lefTreeNode=" + lefTreeNode +
                ", rightNode=" + rightNode +
                ", value=" + value +
                '}';
    }
}
