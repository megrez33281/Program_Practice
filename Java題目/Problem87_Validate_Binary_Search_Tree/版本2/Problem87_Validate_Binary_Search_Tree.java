/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
package Problem87_Validate_Binary_Search_Tree;
import com.sun.source.tree.Tree;

import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Problem87_Validate_Binary_Search_Tree{

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null || (root.right == null && root.left == null)){return true;}
        long[] range = {(long)Integer.MIN_VALUE-1,(long)Integer.MAX_VALUE+1};

        return judge(root,range);
    }

    private boolean judge(TreeNode root, long[] array){
        //若是該node為最尖端，回傳true
        if(root.right == null && root.left == null){
            return true;}
        //根據節點移動方向設定該節點之佐子樹與右子樹之值的有效範圍  如：此次往此節點的右子樹移動，那此節點之右子樹之所有子節點之值都要大於此節點，以此類推
        boolean left = root.left == null || judge(root.left,new long[]{array[0],root.val});
        boolean right = root.right == null || judge(root.right,new long[]{root.val,array[1]});

        boolean bst = (root.left == null || (root.left.val > array[0] && root.left.val < array[1])) && (root.right == null || (root.right.val > array[0] && root.right.val < array[1]));

        return bst && left && right && ((root.left == null || root.left.val < root.val) && (root.right == null || root.right.val > root.val));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



