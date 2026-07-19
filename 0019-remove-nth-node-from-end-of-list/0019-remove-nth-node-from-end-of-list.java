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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        int l=0;
        ListNode temp=head;
        ListNode prev=null;

        while(temp!=null){
            temp=temp.next;
            l++;
        }

        int d=l-n;
        if (d == 0) return head.next; 
        temp=head;

        for(int i=0;i<d;i++){
            prev=temp;
            temp=temp.next;
        }

        prev.next=temp.next;

        return head;
    }
}