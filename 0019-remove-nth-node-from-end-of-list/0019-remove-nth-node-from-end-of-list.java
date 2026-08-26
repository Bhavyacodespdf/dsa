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
        int l=0;
        ListNode temp=head;
        if(temp.next==null) return null;

        while(temp.next!=null){
            l++;
            temp=temp.next;
        }

        int d=l-n+1;
        temp=head;
        ListNode prev=head;
        if(d==0) return head.next;

        for(int i=0;i<d;i++){
            prev=temp;
            temp=temp.next;
        }

        prev.next=temp.next;

        return head;
    }
}