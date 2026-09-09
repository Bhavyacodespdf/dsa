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
        ListNode temp=head;
        int len=1;

        while(temp!=null && temp.next!=null){
            temp=temp.next;
            len++;
        }

        temp=head;
        int d=len-n-1;
        if(d==-1) return temp.next;

        for(int i=0;i<d;i++){
            temp=temp.next;
        }

        temp.next=temp.next.next;

        return head;
    }
}