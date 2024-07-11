/**
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
package Problem84_UUnique_Binary_Search_Trees_II;
import com.sun.source.tree.Tree;

import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Problem84_UUnique_Binary_Search_Trees_II{

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

//規則：左子樹小於跟節點的值，右子樹大於跟節點的值
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){return new ArrayList<TreeNode>();}
        return combine(1,n);//建立以(1~n)的BST
    }

    //建立BST
    private List<TreeNode> combine(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        //停止
        if(start > end){
            ans.add(null);
            return ans;
        }
        //建立此跟節點的左子樹與右子樹串列
        for(int i=start; i<=end; i++) {
            List<TreeNode> leftTree = combine(start, i - 1);//建立i的左子樹串列(得到(start~i-1)的BST)
            List<TreeNode> rightTree = combine(i + 1, end);//建立i的右子樹串列(得到(i+1~end)的BST)
            //選擇左右子樹
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);//每次添加root到ans，其ans都會返回到上一層的leftTree或rightTree，直到最上層，返回到 generateTrees}
                }

            }
        }
        return ans;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;}
}





