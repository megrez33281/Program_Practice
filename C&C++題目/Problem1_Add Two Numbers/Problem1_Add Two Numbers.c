
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


struct ListNode {
    int val;
    struct ListNode *next;}; //下一個ListNode之地址
//函式
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    if(!l1)return l2;
    if(!l2)return l1;
    //printf("test %d\n", l1->val);
    struct ListNode *ans = (struct ListNode*)malloc(sizeof(struct ListNode));//配置動態記憶體，避免函式結束後記憶體被釋放
    struct ListNode *temp = ans;
    struct ListNode *current;

    int carry = 0;
    int num1,num2;

    while(l1 || l2){
        num1 = l1?l1->val:0;
        num2 = l2?l2->val:0;
        //printf("%d %d\n", num1,num2);
        current = (struct ListNode*)malloc(sizeof(struct ListNode));
        current-> val = (num1+num2+carry)%10;
        temp -> next = current;
        temp = temp->next;
        carry = (num1+num2+carry)/10;
        if(l1)l1 = l1->next;
        if(l2)l2 = l2->next;
    }
    //最後加上進位
    if(carry == 1){
        current = (struct ListNode*)malloc(sizeof(struct ListNode));
        current-> val = 1;
        temp -> next = current;
        temp = temp -> next;
    }
    temp->next = NULL;
    temp = ans->next;
    free(ans);//釋放記憶體(最開始創建的一個ListNode*，最後並不會回傳，因此最後將其釋放，其餘見的動態記憶體皆會被回傳)
    //假設最後答案共有n個ListNode，在計算時，共創建了n+1個動態記憶體，因此最後須釋放一個動態記憶體

    return temp;
}

int main(){
    struct ListNode thr =  {3};
    struct ListNode sec =  {4,&thr};
    struct ListNode head = {2,&sec};

    struct ListNode thrI =  {4};
    struct ListNode secI =  {6,&thrI};
    struct ListNode headI = {5,&secI};

    //若型別為ListNode，以"."取得變數，若型別為ListNode*，以"->"取得變數
    //printf("%d\n", headI.val);
    struct ListNode* ans = addTwoNumbers(&head,&headI);
    //當使用的是動態記憶時，以ans->next取得下一個ListNode的地址會導致無限循環
    printf("%d",ans->val);

    return 0;
}


