// Problem: Remove nodes that have a greater value on the right side
// Idea: Reverse list + track maximum so far
// How: Reverse list, remove nodes smaller than max, reverse again
// Time: O(n), Space: O(1)


class Solution {
    public ListNode reverse(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next=head;
            head.next=null;
    return last;
}
    public ListNode removeNodes(ListNode head) {
        head= reverse(head);
        int max=head.val;
        ListNode curr =head;
        while(curr.next!=null){
            if(curr.next.val<max){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
                max=curr.val;
            }

        }
        return reverse(head);
    }
}