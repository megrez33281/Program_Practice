/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(!head){
            return head;
        }
        ListNode* ptr = head;
        while(ptr->next && ptr->next > ptr){
            //若沒有特意的清除，在程式執行時新增的ListNode，其address應會逐漸遞增，因此可以利用此特性來找到cycle
            ptr = ptr->next;
        }
        return ptr->next;
    }
};