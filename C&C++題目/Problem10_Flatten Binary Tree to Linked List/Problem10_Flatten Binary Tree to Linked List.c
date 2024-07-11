/*Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */

#include <stdio.h>
#include <string.h>


struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
  };



void flatten(struct TreeNode* root){

    struct TreeNode* curr = root;

    while(curr){

        if(curr->left){//檢測左子樹存在，若不存在則直接跳過
            //先將當前node之右子樹接到當前node之左子樹之最右邊的leafnode，可避免需要儲存當前node之右子樹的問題
            struct TreeNode* temp = curr->left;
            //找到當前node之左子樹之最右邊的leafnode
            while(temp->right){
                temp = temp->right;
            }
            temp->right = curr->right;  //將當前node之右子樹接到當前node之左子樹之最右邊的leafnode
            curr->right = curr->left;   //將當前node之左子樹接到當前node之右子樹
            curr->left = NULL;

        }

        curr = curr->right; //往右遍歷

    }

}

int main(){




    return 0;
}

