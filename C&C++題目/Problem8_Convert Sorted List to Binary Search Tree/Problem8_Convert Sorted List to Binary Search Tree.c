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
    /*�ѩ��D�ص�����ListNode�g�L�ƧǡA���ListNode������Ƭ��ڡA�䥪�����ȬҤp��ڬҬ����l��A�k�����j��ڬҬ��k�l�ơA�H���覡���j����BST�̸`��BST�e�Ϊ��Ŷ�*/
    /*��XListNode�������Ȱ���TreeNode�ðj��*/
    //�����X�n�^�Ǫ�TreeNode(����J��)
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->left = NULL;
    root->right = NULL;
    //�]�m�X�f
    if(head == NULL){return root;}
    else if(head->next == NULL){//ListNode���׬�1������
        root->val = head->val;
        return root;
    }

    //���ListNode������node(��ListNode���׬����ƮɡA��ܥk�䪺�@������node)
    int length = 0;
    struct ListNode* temp = head;
    while(temp){
        length++;
        temp = temp->next;
    }
    int middle = (length/2) + 1;
    //��줤��node���e�@��node�ñNlistNode���_
    temp = head;
    for(int i=1; i<middle-1; i++){
        temp = temp->next;
    }
    //����temp���VListNode������node���e�@�Ӧ�m
    struct ListNode* right = temp->next->next;
    root->val = temp->next->val;
    temp->next = NULL;//�_�}�s��

    root->left = sortedListToBST(head);//�����ȥ����ݩ󥪤l��
    root->right = sortedListToBST(right);//�����ȥ����ݩ�k�l��


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

