/*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.*/

#include <stdio.h>
#include <string.h>


struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  };


struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize){
    //postorder：左-->右-->中
    //inorder：左->中-->右

    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    //初始化
    root->val = postorder[postorderSize-1]; //找到根
    root->left = NULL;
    root->right = NULL;

    if(postorderSize == 1){return root;}//只有根

    //找出根在inorder中的位置，其左側為左子樹，右側為右子數
    int index = 0;
    while(inorder[index] != root->val){index++;}

    if(index >= 1){//找左子樹
        printf("%d\n",postorder[0]);
        root->left = buildTree(inorder,index,postorder,index);}

    if(postorderSize-1-index >= 1){//找右子樹
        printf(" %d\n",postorder[index+1]);
        root->right = buildTree(inorder + index + 1,inorderSize-1-index,postorder+index,postorderSize-1-index);}


    return root;



}

int main(){

    int inorder[5] = {9,3,15,20,7};
    int postorder[5] = {9,15,7,20,3};

    struct TreeNode* answer = buildTree(inorder,5,postorder,5);
    printf("%d\n",answer->val);
    return 0;
}

