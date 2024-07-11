/**
Given the head of a linked list, rotate the list to the right by k places.
 */
package Problem64_Rotate_List;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem64_Rotate_List{

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode thr = new ListNode(2);
        ListNode sec = new ListNode(1,thr);
        ListNode head = new ListNode(0,sec);

        ListNode ans = solution.rotateRight(head,4);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;}

    }
}
//解法：由轉的次數(取餘數)計算出起點，作為新的ListNode的起點，之後再將原先ListNode的起點接到新ListNode的起點後面
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){return null;}
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;}
        int n = k % len;
        if(n == 0){return head;}
        else{
            int count = len;
            ListNode newHead = head;
            while(count > n){
                count--;
                newHead = newHead.next;
            }
            temp = newHead;
            while(temp.next != null){temp = temp.next;}
            int sub = len - count;
            temp.next = head;
            while(sub > 0){
                temp = temp.next;
                sub--;}
            temp.next = null;
            return newHead;
        }

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
