/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 /*
 重點：將Linked List分成左右兩部分，並將右半部分顛倒，再從左半部分以及顛倒的右半部分的Linked List交互串聯即可
 **當右半部分長度小於等於左半部分時右半部分會先結束
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        //先將ListNode分成兩半
        ListNode* Fast = head;
        ListNode* Slow = head;
        while(Fast){
            Slow = Slow->next;
            Fast = Fast->next;
            if(Fast){
                 Fast = Fast->next;
            }
        }
        if((!Fast && !Slow) || head->next == Slow){
            return;
        }
        //此時Slow會指向Linked List的右半部分的第一個node
        //將Linked List的右半部分反轉
        ListNode* temp = Slow->next;
        Slow->next = NULL;
        while(temp){
            ListNode* tem = temp->next;
            temp->next = Slow;
            Slow = temp;
            temp = tem;
        }

        //依序將左半部分的Linked List與反轉的右半部分Linked List連接
        ListNode* left_ptr = head;
        ListNode* right_ptr = Slow;
        while(left_ptr != Slow){
            temp = left_ptr->next;  //儲存原先left_ptr的next;
            left_ptr->next = right_ptr; //將left_ptr的next指向right_ptr;
            if(!right_ptr){
                break;
            }
            left_ptr = temp;    //將left_ptr存為原先left_ptr的next;
            temp = right_ptr->next;    //儲存原先right_ptr的next;
            right_ptr->next = left_ptr; //將right_ptr的next指向left_ptr（此時left_ptr已指向原先的下一node）;
            right_ptr = temp;   //將right_ptr存為原先left_ptr的next;
        }

        
    }
};