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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null) return null;
        if(k==0) return head;
        ListNode temp1=head;
        ListNode temp2=head;

        for(int i=1;i<k;i++){
            temp1=temp1.next;
        }
        int val1=temp1.val;

        int c=0;
        while(temp2!=null){
            c++;
            temp2=temp2.next;
        }

        int d=c-k;
        temp2=head;

        for(int i=1;i<d+1;i++){
            temp2=temp2.next;
        }

        int val2=temp2.val;
        temp2.val=val1;
        temp1.val=val2;

        return head;
    }
}