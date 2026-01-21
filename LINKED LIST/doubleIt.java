🔹 Idea

Avoid reversing the list

Handle carry by looking at the next digit

Works because doubling a digit ≥ 5 produces a carry

🔹 Algorithm

Extra head handling

If first digit ≥ 5, add a new node 0 at the front

Prevents overflow at most significant digit

Traverse the list:

Double current digit → (digit * 2) % 10

If next digit ≥ 5, add carry → +1

Return head*/


class Solution {
   public ListNode doubleIt(ListNode head) {
     if(head.val>=5){
        ListNode newHead=new ListNode(0);
        newHead.next=head;
        head=newHead;
     }
     ListNode curr = head;
     while(curr!=null){
        curr.val= (curr.val*2)%10;
        if(curr.next!=null && curr.next.val>=5){
            curr.val+=1;
        }
        curr=curr.next;
     }
     return head;
    }
}


 // Steps to double a number stored in a linked list:
// 1. Reverse the linked list
// 2. Traverse and double each digit with carry
// 3. Add remaining carry (if any)
// 4. Reverse the list back
 /*   
 
 public ListNode reverse(ListNode head){
 if(head==null || head.next==null){
            return head;
        }
        ListNode last= reverse(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    public ListNode doubleIt(ListNode head) {
      head =reverse(head);
        ListNode curr =head;
        ListNode prev = null;
        int carry=0;
        while(curr!=null){
            int newValue= curr.val*2+carry;
            curr.val=newValue%10;
            if(newValue>=10){//handaling carry
                carry=1;
            }
                else{
                    carry=0;
                }
                prev=curr;
                curr=curr.next;
        }
        if(carry!=0){
                ListNode newhead=new ListNode(carry);
                prev.next=newhead;
            }
        return reverse(head);*/