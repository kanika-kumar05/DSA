/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode head){
          if(head==null || head.next==null) return head;

        ListNode newHead=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        dummy.next=head;
        ListNode t1=head;

        for(int i=1;i<left;i++){
            prev=prev.next;
            t1=t1.next;
        }
        ListNode t2=t1;
        for(int i=left;i<right;i++){
            t2=t2.next;
        }
       ListNode nextNode=t2.next;
       t2.next=null;
       prev.next=null;
       ListNode newHead=reverse(t1);
       prev.next=newHead;
       t1.next=nextNode;
       return dummy.next;


    }
}