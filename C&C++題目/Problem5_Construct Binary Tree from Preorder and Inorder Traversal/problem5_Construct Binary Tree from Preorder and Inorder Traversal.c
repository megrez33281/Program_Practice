/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.*/

#include <stdio.h>
#include <string.h>


struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  };


struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){
    //preorder：中-->左-->右
    //inorder：左->中-->右

    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    //初始化
    root->val = preorder[0];
    root->left = NULL;
    root->right = NULL;

    if(preorderSize == 1){return root;}

    int index = 0;

    while(inorder[index] != root->val){index++;}//找出根在inorder中的位置，其左側為左子樹，右側為右子數

    if(index >= 1){//找左子樹
        root->left = buildTree(preorder+1,index,inorder,index);}

    if(preorderSize-1-index >= 1){//找右子樹
        root->right = buildTree(preorder+1+index,preorderSize-1-index,inorder + index+1,inorderSize-1-index);}


    return root;



}

int main(){

    int preorder[5] = {3,9,20,15,7};
    int preorderSize = 5;
    int inorder[5] = {9,3,15,20,7};
    int inorderSize = 5;
    struct TreeNode* answer = buildTree(preorder,preorderSize,inorder,inorderSize);
    printf("%d",answer->right->right->val);


    return 0;
}

