
#include <stdio.h>
#include <string.h>


struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  };

struct TreeNode* Min;
struct TreeNode* Max;

void recoverTree(struct TreeNode* root){
    if(root == 0){return;}

    //同時出現兩處錯誤的情形(左右子樹皆有不符規定之node)
    if(root->left != 0 && root->right != 0){
        Max = root->left;
        check_left(root->left);

        Min = root-> right;
        check_right(root->right);
        if(root->val < Max->val && root->val > Min->val){
            int temp = Max->val;
            Max->val = Min->val;
            Min->val = temp;
            return;
        }

    }

    //出現一處錯誤的情形
    //左子樹中有不符規定之node
    if(root->left != 0){

        Max = root->left;
        check_left(root->left);

        if(root->val < Max->val){
            int temp = root->val;
            root->val = Max->val;
            Max->val = temp;
            return;
    }}

     //右子樹中有不符規定之node
    if(root->right != 0){

        Min = root-> right;
        printf("%d\n",Min->val);
        check_right(root->right);
        printf("%d\n",Min->val);
        if(root->val > Min->val){
            int temp = root->val;
            root->val = Min->val;
            Min->val = temp;
            return;
        }


    }



    recoverTree(root->left);
    recoverTree(root->right);


}

void check_left(struct TreeNode* ptr){
    //找到左子樹中的最大值之node
    if(ptr == 0){return;}

    if(ptr-> val > Max-> val){Max = ptr;}//中

    check_left(ptr->left);
    check_left(ptr->right);

}
void check_right(struct TreeNode* ptr){
    //找到右子樹中的最大值之node
    if(ptr == 0){return;}
    printf("test:%d\n",Min->val);

    if(ptr-> val < Min-> val){

        Min = ptr;
        printf("The Min: %d\n",Min->val);
        }//中

    check_right(ptr->left);
    check_right(ptr->right);

}

int main(){

    return 0;
}

