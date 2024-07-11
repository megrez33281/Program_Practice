/*Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.*/

#include <stdio.h>
#include <string.h>


struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
  };

struct node{

    int level;
    struct TreeNode *root;
    struct node* next;

};

struct Stack{

    struct node *top;

};

struct Stack CreateStack(){

    struct Stack stack;
    stack.top = NULL;

    return stack;

}

int IsEmpty(struct Stack* stack){

    return (stack->top == NULL)?1:0;
}

void push(struct Stack* stack, struct TreeNode* node, int level){

    struct node* anode = (struct node*)malloc(sizeof(struct node));
    anode->level = level;
    anode->root = node;
    anode->next = NULL;

    if(IsEmpty(stack)){

        stack->top = anode;
    }

    else{
        anode->next = stack->top;
        stack->top = anode;

    }
}

struct node pop(struct Stack* stack){

    if(IsEmpty(stack)){return;}

    struct node anode;
    anode.level = stack->top->level;
    anode.root = stack->top->root;
    anode.next = NULL;
    struct node* temp = stack->top;
    stack->top = stack->top->next;
    free(temp);

    return anode;

}

/*struct node* MakeNode(struct TreeNode* treenode, int level){

    struct node* anode = (struct node*)malloc(sizeof(struct node));
    anode->next = NULL;
    anode->level = level;
    anode->root = TreeNode;

    return anode;
}*/

int IsLeaf(struct TreeNode* node){

    return (node->left == NULL && node->right == NULL)?1:0;
}


int** pathSum(struct TreeNode* root, int targetSum, int* returnSize, int** returnColumnSizes){

    int** answer = (int**)malloc(sizeof(int*)*2000);
    *(returnColumnSizes) = (int*)malloc(sizeof(int)*2000);

    memset(answer,0,2000*sizeof(int*));
    memset(*returnColumnSizes,0,2000*sizeof(int));

    if(root == NULL){
        returnColumnSizes[0] = 0;
        *returnSize = 0;
        return answer;
    }

    struct Stack stackTraverse = CreateStack(); //用來輔助遍歷Binary Tree
    struct Stack stackPath = CreateStack(); //用來儲存路徑
    int nodeLevel = 0;  //儲存當前處理的node的層數
    push(&stackTraverse,root,nodeLevel);
    int returnLevel = 0; //紀錄answer當前層數

    while(!IsEmpty(&stackTraverse)){

        struct node anode = pop(&stackTraverse);
        if(anode.root->right){
            push(&stackTraverse,anode.root->right,nodeLevel+1);}//將右子樹放入stakTraverse
        if(anode.root->left){
            push(&stackTraverse,anode.root->left,nodeLevel+1);}//將左子樹放入stackTraverse

        //確認當前路徑正確性
        while(!IsEmpty(&stackPath) && stackPath.top->level != nodeLevel-1){
            struct node temp = pop(&stackPath);
            targetSum += temp.root->val;
            nodeLevel--;
        }
        push(&stackPath,anode.root,nodeLevel);
        targetSum -= anode.root->val;

        if(IsLeaf(anode.root) && targetSum == 0){
            //儲存路徑
            answer[returnLevel] = (int*)malloc(sizeof(int)*(nodeLevel+1));
            (*returnColumnSizes)[returnLevel] = nodeLevel+1;
            for(int i= nodeLevel; i>=0; i--){
                answer[returnLevel][i] = stackPath.top->root->val;
            }
            returnLevel++;
        }


        nodeLevel++;
    }


    answer = (int**)realloc(answer,sizeof(int*)*returnLevel);
    *returnColumnSizes = (int*)realloc((*returnColumnSizes),sizeof(int)*returnLevel);

    *returnSize = returnLevel;
    return answer;



}


int main(){




    return 0;
}

