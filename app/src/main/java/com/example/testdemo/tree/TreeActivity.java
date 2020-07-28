package com.example.testdemo.tree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.R;
import com.example.testdemo.LLog;

public class TreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        int[] arrays = {2, 1, 10,15,20};

        //动态创建树

        TreeRoot root = new TreeRoot();
        for (int value : arrays) {
            createTree(root, value);
        }

        //先序遍历树
        preTraverseBTree(root.getTreeRoot());
        System.out.println("---------------：Java3y");

        //中序遍历树
        inTraverseBTree(root.getTreeRoot());
        System.out.println("---------------：Java3y");

        getHeight(root.getTreeRoot());
    }

    /**
     * 先序遍历
     *
     * @param rootTreeNode 根节点
     */
    public static void preTraverseBTree(TreeNode rootTreeNode) {

        if (rootTreeNode != null) {

            //访问根节点
            System.out.println(rootTreeNode.getValue());

            //访问左节点
            preTraverseBTree(rootTreeNode.getLefTreeNode());

            //访问右节点
            preTraverseBTree(rootTreeNode.getRightNode());
        }
    }

    /**
     * 中序遍历
     *
     * @param rootTreeNode 根节点
     */
    public static void inTraverseBTree(TreeNode rootTreeNode) {

        if (rootTreeNode != null) {

            //访问左节点
            inTraverseBTree(rootTreeNode.getLefTreeNode());

            //访问根节点
            System.out.println(rootTreeNode.getValue());

            //访问右节点
            inTraverseBTree(rootTreeNode.getRightNode());
        }
    }


    /**
     * 动态创建二叉查找树
     *
     * @param treeRoot 根节点
     * @param value    节点的值
     */
    public static void createTree(TreeRoot treeRoot, int value) {


        //如果树根为空(第一次访问)，将第一个值作为根节点
        if (treeRoot.getTreeRoot() == null) {
            TreeNode treeNode = new TreeNode(value);
            treeRoot.setTreeRoot(treeNode);

        } else {

            //当前树根
            TreeNode tempRoot = treeRoot.getTreeRoot();

            while (tempRoot != null) {
                //当前值大于根值，往右边走
                if (value > tempRoot.getValue()) {

                    //右边没有树根，那就直接插入
                    if (tempRoot.getRightNode() == null) {
                        tempRoot.setRightNode(new TreeNode(value));
                        return;
                    } else {
                        //如果右边有树根，到右边的树根去
                        tempRoot = tempRoot.getRightNode();
                    }
                } else {
                    //左没有树根，那就直接插入
                    if (tempRoot.getLefTreeNode() == null) {
                        tempRoot.setLefTreeNode(new TreeNode(value));

                        return;
                    } else {
                        //如果左有树根，到左边的树根去
                        tempRoot = tempRoot.getLefTreeNode();
                    }
                }
            }
        }
    }

    //头晕的递归思想
    /***
     * 递归：你打开面前这扇门，看到屋里面还有一扇门（这门可能跟前面打开的门一样大小（静），也可能门小了些（动）），
     * 你走过去，发现手中的钥匙还可以打开它，你推开门，发现里面还有一扇门，你继续打开，。。。， 若干次之后，
     * 你打开面前一扇门，发现只有一间屋子，没有门了。 你开始原路返回，每走回一间屋子，你数一次，走到入口的时候，
     * 你可以回答出你到底用这钥匙开了几扇门。
     * */
    public static int getHeight(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        } else {
            LLog.d("dsadwqewqewq_", treeNode.getValue());
            //左边的子树深度
            int left = getHeight(treeNode.getLefTreeNode());
            LLog.d("dsadwqewqewq_left", left);
            //右边的子树深度
            int right = getHeight(treeNode.getRightNode());
            LLog.d("dsadwqewqewq_right", right);

            int max = left;

            if (right > max) {
                max = right;
            }
            return max + 1;
        }
    }


}