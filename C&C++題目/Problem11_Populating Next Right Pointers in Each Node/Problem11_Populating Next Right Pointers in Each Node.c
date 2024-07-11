/*You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

*/

#include <stdio.h>
#include <string.h>


struct Node {
    int val;
    struct Node *left;
    struct Node *right;
    struct Node *next;
};



struct Node* connect(struct Node* root) {

    //preorder ��-->��-->�k
    if(root == NULL){return root;}

    struct Node* left = root->left;
    struct Node* right = root->right;
    while(left){
        //���s����k
        left->next = right;
        left = left->right;
        right = right->left;
    }

	connect(root->left);
	connect(root->right);
	return root;
}

int main(){




    return 0;
}

