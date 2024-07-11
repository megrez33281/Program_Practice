/**
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
package Problem77_Remove_Duplicates_from_Sorted_List_II;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem77_Remove_Duplicates_from_Sorted_List_II{

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode fiveI = new ListNode(5);
        ListNode five = new ListNode(5);
        ListNode fourI = new ListNode(4,five);
        ListNode four = new ListNode(4, fourI);
        ListNode thrI = new ListNode(3,four);
        ListNode thr = new ListNode(3);
        ListNode secI = new ListNode(2,thr);
        ListNode sec = new ListNode(2,thr);
        ListNode firstI = new ListNode(1,sec);
        ListNode first = new ListNode(1,firstI);
        ListNode head = new ListNode(1,first);
        ListNode ans = solution.deleteDuplicates(head);

        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}

//解法：以cur和pre為指標，temp作為ans的指標，當cur與pre不同時，藉由temp，在ans中接上pre。相同時，移動pre，直到其為一新的值。須注意，head的最後一項沒有重複，pre最後的值須在while外面接上，若重複，pre也會跑到null
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        if(cur == null || cur.next == null){return head;}
        cur = cur.next;

        while(cur != null){
            if(cur.val != pre.val){
                temp.next = pre;
                temp = temp.next;
                cur = cur.next;
                pre = pre.next;}
            else{
                int value = cur.val;
                while(pre!= null && pre.val == value ){
                    if(cur != null){cur = cur.next;}
                    pre = pre.next;}}}
        if(pre!=null){temp.next = pre;}
        else{temp.next = null;}//若是head的尾部重複，須將temp的next設為null，避免ans沿著head的順序延續下去

        return ans.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }