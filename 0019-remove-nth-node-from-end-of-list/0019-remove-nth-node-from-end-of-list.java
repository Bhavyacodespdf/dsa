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
        ListNode dummy=temp;
        int c=0;

        while(temp!=null){
            c++;
            temp=temp.next;
        }

        int d=c-n;
        if(d==0) return head.next;
        temp=head;

        for(int i=1;i<d;i++){
            temp=temp.next;
        }
        
        temp.next=temp.next.next;

        return dummy;
    }
}