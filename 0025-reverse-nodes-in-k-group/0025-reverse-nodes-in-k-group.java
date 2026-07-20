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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode nextnode=null;
        ListNode prevnode=null;

        while(temp!=null){
            ListNode kth=findk(temp,k);
            if(kth==null){
                prevnode.next=temp;
                break;
            }
            else{
                nextnode=kth.next;
                kth.next=null;

                rev(temp);

                if(temp==head) head=kth;
                else prevnode.next=kth;

                prevnode=temp;
                temp=nextnode;
            }
        }

        return head;
    }

    public ListNode findk(ListNode temp,int k){
        for(int i=1;i<k && temp != null;i++){
            temp=temp.next;
        }

        return temp;
    }

    public void rev(ListNode temp){
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
    }
}