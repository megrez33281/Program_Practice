/*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.*/

#include <stdio.h>
#include <string.h>


struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  };


struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize){
    //postorder�G��-->�k-->��
    //inorder�G��->��-->�k

    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    //��l��
    root->val = postorder[postorderSize-1]; //����
    root->left = NULL;
    root->right = NULL;

    if(postorderSize == 1){return root;}//�u����

    //��X�ڦbinorder������m�A�䥪�������l��A�k�����k�l��
    int index = 0;
    while(inorder[index] != root->val){index++;}

    if(index >= 1){//�䥪�l��
        printf("%d\n",postorder[0]);
        root->left = buildTree(inorder,index,postorder,index);}

    if(postorderSize-1-index >= 1){//��k�l��
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

