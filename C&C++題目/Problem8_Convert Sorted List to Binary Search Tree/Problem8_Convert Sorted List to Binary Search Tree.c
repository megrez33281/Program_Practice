/*Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).*/

#include <stdio.h>
#include <string.h>

struct ListNode {
    int val;
    struct ListNode *next;
 };

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
  };


struct TreeNode* sortedListToBST(struct ListNode* head){
    /*由於題目給予的ListNode經過排序，找到ListNode的中位數為根，其左側之值皆小於根皆為左子樹，右側接大於根皆為右子數，以此方式遞迴完成BST最節省BST占用的空間*/
    /*找出ListNode的中間值做成TreeNode並迴傳*/
    //先做出要回傳的TreeNode(未放入值)
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->left = NULL;
    root->right = NULL;
    //設置出口
    if(head == NULL){return root;}
    else if(head->next == NULL){//ListNode長度為1的情形
        root->val = head->val;
        return root;
    }

    //找到ListNode的中間node(當ListNode長度為偶數時，選擇右邊的作為中間node)
    int length = 0;
    struct ListNode* temp = head;
    while(temp){
        length++;
        temp = temp->next;
    }
    int middle = (length/2) + 1;
    //找到中間node的前一個node並將listNode切斷
    temp = head;
    for(int i=1; i<middle-1; i++){
        temp = temp->next;
    }
    //此時temp指向ListNode中間的node的前一個位置
    struct ListNode* right = temp->next->next;
    root->val = temp->next->val;
    temp->next = NULL;//斷開連接

    root->left = sortedListToBST(head);//中間值左側屬於左子樹
    root->right = sortedListToBST(right);//中間值左側屬於右子樹


    return root;

}



int main(){

    struct ListNode* first = (struct ListNode*)malloc(sizeof(struct ListNode));
    first->val = -10;
    struct ListNode* second = (struct ListNode*)malloc(sizeof(struct ListNode));
    second->val = -3;
    first->next = second;
    struct ListNode* third = (struct ListNode*)malloc(sizeof(struct ListNode));
    third->val = 0;
    second->next = third;
    struct ListNode* four = (struct ListNode*)malloc(sizeof(struct ListNode));
    four->val = 5;
    third->next = four;
    struct ListNode* fifth = (struct ListNode*)malloc(sizeof(struct ListNode));
    fifth->val = 9;
    four->next = fifth;
    fifth->next = NULL;

    struct TreeNode* answer = (struct TreeNode**)malloc(sizeof(struct TreeNode));
    answer = sortedListToBST(first);



    return 0;
}

