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

// Problem: Merge nodes between zeros in a linked list
// Idea: Two pointers + running sum
// How: Traverse between zeros, sum values, store sum in first node after zero
// Time: O(n), Space: O(1)

class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p1=head.next;
        ListNode p2=p1;
        while(p2!=null){
            int sum=0;
        while(p2!=null&&p2.val!=0){
            sum= sum+p2.val;
            p2=p2.next;
        }
        p1.val=sum;
        p2=p2.next;//move next to 0
        p1.next=p2;
        p1=p1.next;
        }
        return head.next;
    }
}