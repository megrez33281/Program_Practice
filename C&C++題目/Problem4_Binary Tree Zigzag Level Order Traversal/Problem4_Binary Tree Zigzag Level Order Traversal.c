/*Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).*/

#include <stdio.h>
#include <string.h>


struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  };

struct Node{
    struct TreeNode* node;
    struct Node* next;
};

struct Queue{
    struct Node *head;
    struct Node *tail;
};

struct Queue CreateQueue(){

    struct Queue queue;
    queue.head = (struct Node*)malloc(sizeof(struct Node));//�n�D�@�ӪŶ�
    memset(queue.head,0,sizeof(struct Node));//��l��
    queue.tail = queue.head;
    return queue;
};

int IsEmpty(struct Queue* queue){

    return (queue->head == queue->tail)?1:0;
}

void add(struct Queue* queue,struct TreeNode* node){
    struct Node* tempnode = (struct Node*)malloc(sizeof(struct Node));
    tempnode->node = node;

    queue->tail->next = tempnode;
    queue->tail = queue->tail->next;

}

struct TreeNode* deQueue(struct Queue* queue){

    if(!IsEmpty(queue)){

        struct TreeNode* k = queue->head->next->node;
        struct Node* temp = queue->head;
        queue-> head = queue->head->next;
        free(temp);
        return k;
    }

    return -1;
}

int** zigzagLevelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes){

    //returnSize�ΨӰO��Binary Tree ��level
    //returnColumnSizes�ΨӰO���C�@�h��node�ƶq
    //��̨ϥΪ��Ŷ�"��"�ۦP

    int **answer = (int**)malloc(sizeof(int*)*2000); //�j�p����TreeNode��Level
    *returnColumnSizes = (int*)malloc(sizeof(int)*20000);//"*"��ܳX�ݦa�}�A�HreturnColumnSizes�����O�ӬݡA�X�ݦa�}�����O��int*

    memset(answer,0,2000*sizeof(int*));
    memset(*returnColumnSizes,0,2000*sizeof(int));

    if(root == NULL){
        *returnSize = 0;
        (*returnColumnSizes)[0] = 0;
        return answer;
    }

    struct Queue queue = CreateQueue();
    add(&queue,root);

    int level = 0;  //��e�h��
    int len = 1;    //�Ӽh��node��
    while(!IsEmpty(&queue)){
        answer[level] = (int*)malloc(sizeof(int)*len);  //�V�t�ί���node�ƶq�������j�p���Ŷ�
        (*returnColumnSizes)[level] = len; //�����Ӽhnode�ƶq�@��Ū���ɪ����ר̾�
        int nextLen = 0;    //�����U�@�h��node�ƶq
        //��level�h�M��
        for(int i=0; i<len; i++){
            struct TreeNode* temp = deQueue(&queue);    //���Xnode
            if(level%2 == 0){//level�����ơA���Ǧs��
                answer[level][i] = temp->val;
            }
            else{//level���_�ơA�˧Ǧs��
                answer[level][len-1-i] = temp->val;
            }

            //�N��node�����k�l��[�Jqueue
            if(temp->left){//�Y�s�b���l��A�N��[�Jqueue
                add(&queue,temp->left);
                nextLen++;}  //�ѩ�O�N���k�l��[�Jqueue�AnextLen�p��쪺�����U�@�h��node���@

            if(temp->right){//�Y�s�b�k�l��A�N��[�Jqueue
                add(&queue,temp->right);
                nextLen++;}
            }



        len = nextLen;  //��s�ܤU�@�h��node�ƶq
        level++; //�e���U�@�h

    }

    //�N�h�l�Ŷ��k��(��s�Ŷ�)
    answer = (int**)realloc(answer,sizeof(int*)*level);
    *returnColumnSizes = (int*)realloc((*returnColumnSizes),sizeof(int)*level);

    *returnSize = level;
    return answer;
}

int main(){
    struct Queue queue = CreateQueue();
    struct TreeNode* a = (struct TreeNode*)malloc(sizeof(struct TreeNode));




    return 0;
}

