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
    queue.head = (struct Node*)malloc(sizeof(struct Node));//要求一個空間
    memset(queue.head,0,sizeof(struct Node));//初始化
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

    //returnSize用來記錄Binary Tree 的level
    //returnColumnSizes用來記錄每一層的node數量
    //兩者使用的空間"數"相同

    int **answer = (int**)malloc(sizeof(int*)*2000); //大小等於TreeNode之Level
    *returnColumnSizes = (int*)malloc(sizeof(int)*20000);//"*"表示訪問地址，以returnColumnSizes的型別來看，訪問地址的型別為int*

    memset(answer,0,2000*sizeof(int*));
    memset(*returnColumnSizes,0,2000*sizeof(int));

    if(root == NULL){
        *returnSize = 0;
        (*returnColumnSizes)[0] = 0;
        return answer;
    }

    struct Queue queue = CreateQueue();
    add(&queue,root);

    int level = 0;  //當前層數
    int len = 1;    //該層之node數
    while(!IsEmpty(&queue)){
        answer[level] = (int*)malloc(sizeof(int)*len);  //向系統索取node數量對應的大小之空間
        (*returnColumnSizes)[level] = len; //紀錄該層node數量作為讀取時的長度依據
        int nextLen = 0;    //紀錄下一層的node數量
        //第level層遍歷
        for(int i=0; i<len; i++){
            struct TreeNode* temp = deQueue(&queue);    //取出node
            if(level%2 == 0){//level為偶數，正序存取
                answer[level][i] = temp->val;
            }
            else{//level為奇數，倒序存取
                answer[level][len-1-i] = temp->val;
            }

            //將該node之左右子樹加入queue
            if(temp->left){//若存在左子樹，將其加入queue
                add(&queue,temp->left);
                nextLen++;}  //由於是將左右子樹加入queue，nextLen計算到的必為下一層的node之一

            if(temp->right){//若存在右子樹，將其加入queue
                add(&queue,temp->right);
                nextLen++;}
            }



        len = nextLen;  //更新至下一層的node數量
        level++; //前往下一層

    }

    //將多餘空間歸還(更新空間)
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

