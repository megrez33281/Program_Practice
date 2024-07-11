/*Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */

#include <stdio.h>
#include <string.h>


struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
  };



void flatten(struct TreeNode* root){

    struct TreeNode* curr = root;

    while(curr){

        if(curr->left){//�˴����l��s�b�A�Y���s�b�h�������L
            //���N��enode���k�l�𱵨��enode�����l�𤧳̥k�䪺leafnode�A�i�קK�ݭn�x�s��enode���k�l�𪺰��D
            struct TreeNode* temp = curr->left;
            //����enode�����l�𤧳̥k�䪺leafnode
            while(temp->right){
                temp = temp->right;
            }
            temp->right = curr->right;  //�N��enode���k�l�𱵨��enode�����l�𤧳̥k�䪺leafnode
            curr->right = curr->left;   //�N��enode�����l�𱵨��enode���k�l��
            curr->left = NULL;

        }

        curr = curr->right; //���k�M��

    }

}

int main(){




    return 0;
}

