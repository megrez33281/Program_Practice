/**
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
 */
package Problem78_Partition_List;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem78_Partition_List{

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode fiveI = new ListNode(5);
        ListNode sec = new ListNode(2);
        ListNode five = new ListNode(5,sec);
        ListNode fourI = new ListNode(4,five);
        ListNode secI = new ListNode(2,five);
        ListNode thrI = new ListNode(3,secI);
        ListNode four = new ListNode(4,thrI);
        ListNode thr = new ListNode(3);
        ListNode firstI = new ListNode(1,sec);
        ListNode first = new ListNode(1);
        ListNode head = new ListNode(2,first);
        ListNode ans = solution.partition(head,2);

        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}

//解法：創建兩個新的ListNode，第一個蒐集小於x的ListNode，第二個蒐集大於等於x的ListNode，之後將兩個ListNode串聯
class Solution {
    public ListNode partition(ListNode head, int x) {
        //將head分為大於等於x的部分和小於x的部分
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode runBefore = before;
        ListNode runAfter = after;
        ListNode temp = head;
        while(temp != null){
            if(temp.val >= x){
                runAfter.next = temp;
                runAfter = runAfter.next;
            }
            else{
                runBefore.next = temp;
                runBefore = runBefore.next;
            }
            temp = temp.next;
        }

        runBefore.next = after.next;
        runAfter.next = null;//避免循環
        return before.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
