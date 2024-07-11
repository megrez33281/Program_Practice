#include <iostream>
#include <vector>
#include <string>

using namespace std;


struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
    public:
        int sumNumbers(TreeNode* root) {
            vector<string> ans = NumList(root);
            int answer = 0;
            for(int i=0; i<ans.size(); i++){
                answer += stoi(ans[i]);
            }
    
            return answer;
        }

        vector<string> NumList(TreeNode* root){
            if(root == NULL){
                return {};
            }
            vector<string> left = NumList(root->left);
            vector<string> right = NumList(root->right);
            vector<string> ans;

            for(int i=0; i<left.size(); i++){
                ans.push_back(to_string(root->val) + left[i]);
            }
            for(int i=0; i<right.size(); i++){
                ans.push_back(to_string(root->val) + right[i]);
            }
            if(ans.size() == 0){
                ans.push_back(to_string(root->val));
            }

            return ans;
        }
};

int main()
{

    struct TreeNode* root = new TreeNode;
    struct TreeNode* left = new TreeNode;
    struct TreeNode* right = new TreeNode;
    struct TreeNode* left_left = new TreeNode;
    struct TreeNode* left_right = new TreeNode;
    left_left->val = 5;
    left_right->val = 1;
    left->left = left_left;
    left->right = left_right;
    left->val = 9;
    right->val = 0;
    root->val = 4;
    root->left = left;
    root->right = right;
    Solution solution;
    int answer = solution.sumNumbers(root);
    cout << answer << endl;
    return 0;
}