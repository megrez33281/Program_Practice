/**
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
package Problem42_Swap_Nodes_in_Pairs
import java.util.*;
import javax.print.DocFlavor;
import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.IntStream;


public class Problem42_Swap_Nodes_in_Pairs{

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode seven = new ListNode(7);
        ListNode six = new ListNode(6,seven);
        ListNode fifth = new ListNode(5,six);
        ListNode four = new ListNode(4,fifth);
        ListNode thr = new ListNode(3,four);
        ListNode sec = new ListNode(2,thr);
        ListNode head = new ListNode(1);
        ListNode temp = solution.swapPairs(head);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }



    }



}
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){return null;}
        else if(head.next == null){return head;}

        ListNode temp = head;
        ListNode ans = head.next;
        ListNode before = new ListNode(0);
        before.next = head;

        while(temp != null && temp.next != null){
            //假設temp此時指向地址為x
            ListNode tem = temp;//存取temp當前指向之地址(x)
            temp = temp.next;//將temp指向下一個地址(x+1)
            tem.next = temp.next;//將x之下一地址設為(x+2) : x,x+2
            temp.next = tem;//將x+1之下一地址指向x : x+1,x,x+2
            before.next = temp;//將x-1地址指向x+1
            before = temp.next;//取得x-1之地址供下一輪使用
            temp = temp.next.next;
        }


        return ans;

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }