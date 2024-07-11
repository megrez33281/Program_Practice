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

//已知當前TreeNode符合BST，判斷下一個TreeNode是否為BST
class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null || (root.right == null && root.left == null)){return true;}
        ArrayList<String[]> left_string_array = new ArrayList<>();
        ArrayList<String[]> right_string_array = new ArrayList<>();
        String[] arrayI = new String[2];
        arrayI[1] = root.val + "";
        arrayI[0] = "left";
        left_string_array.add(arrayI);
        boolean left = (root.left == null || (root.left.val < root.val && judge(root.left,left_string_array)));
        String[] arrayII = new String[2];
        arrayII[1] = root.val + "";
        arrayII[0] = "right";
        right_string_array.add(arrayII);
        boolean right = (root.right == null || (root.right.val > root.val && judge(root.right,right_string_array)));

        return left && right;
    }

    private boolean judge(TreeNode root, ArrayList<String[]> list){
        //需檢查上一個根節點是否皆符合BST
        boolean bst = true;
        for(String[] i:list){
            int num = Integer.parseInt(i[1]);
            if(bst && i[0].equals("left")){
                bst = (root.left == null || root.left.val < num) && (root.right == null || root.right.val < num);
            }
            else if(bst){
                bst = (root.left == null || root.left.val > num) && (root.right == null || root.right.val > num);
            }
        }
        String[] newArrayI = new String[2];
        newArrayI[1] = root.val + "";
        newArrayI[0] = "left";
        ArrayList<String[]> newLeft = new ArrayList<>(list);
        newLeft.add(newArrayI);
        boolean left = root.left == null || judge(root.left,newLeft);
        String[] newArrayII = new String[2];
        newArrayII[1] = root.val + "";
        newArrayII[0] = "right";
        ArrayList<String[]> newRight = new ArrayList<>(list);
        newLeft.add(newArrayII);
        boolean right = root.right == null || judge(root.right,newRight);

        //若是該node為最尖端，回傳true
        if(root.right == null && root.left == null){
            return true;}


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



