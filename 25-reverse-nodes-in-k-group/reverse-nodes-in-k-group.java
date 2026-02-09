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
    public static ListNode find(ListNode temp,int k){
        k--;    // k-- isliye kiya coz temp initialize krte time ek node already include ho gya
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newHead=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode kth=find(temp,k);
            if(kth==null){
                if(prev!=null){
                    prev.next=temp;
                }
                break;
            }
           ListNode next=kth.next;
           kth.next=null;
           reverse(temp);
           if(temp==head){
            head=kth;
           }
           else{
            prev.next=kth;
           }
            prev=temp;
            temp=next;
        }
        return head;
    }
}