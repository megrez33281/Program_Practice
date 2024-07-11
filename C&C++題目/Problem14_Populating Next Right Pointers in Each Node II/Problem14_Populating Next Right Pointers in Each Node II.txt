#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define max(a,b) (a>b)?a:b
#define min(a,b) (a>b)?b:a

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
    struct Node *next;
};



struct Queue{
    struct Node* head;
    struct Node* tail;
};

struct Queue* CreateQueue(){

    struct Queue* queue = (struct Queue*)malloc(1*sizeof(struct Queue));
    queue->head = (struct Node*)malloc(1*sizeof(struct Node));
    queue->tail = queue->head;

    return queue;

}

int IsEmpty(struct Queue* queue){
    return queue->head == queue->tail;
}

void push(struct Queue* queue, struct Node* node){

    if(IsEmpty(queue)){
        queue->tail = node;
        queue->head->next = queue->tail;
    }
    else{
        queue->tail->next = node;
        queue->tail = queue->tail->next;
    }

}

struct Node* pop(struct Queue* queue){

    if(IsEmpty(queue)){
        return NULL;
    }
    else{
        queue->head = queue->head->next;
        return queue->head;


    }
}

struct Node* connect(struct Node* root) {
	if(root == NULL){
        return root;
	}
	struct Queue* queue = CreateQueue();
	push(queue, root);
	int numbers = 1;
	int next_numbers = 0;
	struct Node* pre = NULL;
	struct Node* ptr = NULL;

	while(IsEmpty(queue) == 0){
        pre = ptr;
        ptr = pop(queue);

        if(numbers == 0){
            numbers = next_numbers;
            next_numbers = 0;
            if(pre != NULL){
                pre->next = NULL;
            }

        }
        else{
            if(pre != NULL){
                pre->next = ptr;
            }
        }
        if(ptr->left != NULL){
            push(queue,ptr->left);
            next_numbers++;
        }
        if(ptr->right != NULL){
            push(queue,ptr->right);
            next_numbers++;
        }
        numbers--;
	}
    if(ptr != NULL){
        ptr->next = NULL;
    }
    return root;

}
int main() {
    struct Queue* temp = CreateQueue();
    struct Node* node = (struct Node*)malloc(1*sizeof(struct Node));
    node->val = 2;
    node->left = NULL;
    node->right = NULL;
    node->next = NULL;
    struct Node* nodeI = (struct Node*)malloc(1*sizeof(struct Node));
    nodeI->val = 3;
    nodeI->left = NULL;
    nodeI->right = NULL;
    nodeI->next = NULL;
    push(temp,node);
    push(temp,nodeI);
    struct Node* number1 = pop(temp);
    struct Node* number2 = pop(temp);
    struct Node* number3 = pop(temp);
    printf("%d %d\n", number1->val,number2->val);
    push(temp,node);
    push(temp,nodeI);
    printf("%d\n", temp->head->next->next->val);
    number1 = pop(temp);
    number2 = pop(temp);
    number3 = pop(temp);
    printf("%d %d\n", number1->val,number2->val);

    free(temp);
    free(node);
    free(nodeI);

    return 0;
}
