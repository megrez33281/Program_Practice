/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

package Problem28_Add_Two_Numbers;
import java.lang.String;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;



public class Problem28_Add_Two_Numbers{


    public static void main(String[] args) {



    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0);//target首位val設為零，target.next開始為答案
        ListNode curr = target; //將curr指向 target之地址
        int carry=0;
        while(l1 != null || l2 != null){
            int A = l1 != null? l1.val : 0;
            int B = l2 != null? l2.val : 0;

            int Sum = (A + B +  carry);
            carry = Sum/10;
            System.out.println(Sum%10);
            curr.next= new ListNode(Sum%10);//設定下一地址之value
            curr = curr.next; //將curr指向curr.next之地址
            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;

        }
        if(carry > 0){curr.next = new ListNode(carry);}//若最後carry>0，需要增加一位進位
        return target.next;
    }
}