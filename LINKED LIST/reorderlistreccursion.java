
// Problem: Reorder linked list as L0 → Ln → L1 → Ln-1 → ...
// Idea: Recursion with a global pointer from the front
// How: Recurse to end, then link last node after current front node
// Time: O(n), Space: O(n) (recursion stack)

class Solution {
     ListNode curr;
    public void solve(ListNode head) {
        if(head==null)return;
    solve(head.next);
    ListNode temp =curr.next;
    if(curr.next==null){
        return;
    }
    else if(head==curr){
        head.next=null;
        return;
    }
    curr.next=head;
    head.next=(temp==head)?null:temp;
    curr=temp;
    }
    public void reorderList(ListNode head) {
        curr=head;
    solve(head);

    }}