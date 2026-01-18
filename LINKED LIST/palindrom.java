 /*List<Integer> temp = new ArrayList<>();
    ListNode curr= head;
    while(curr!=null){
        temp.add(curr.val);
        curr=curr.next;
    }
    int i=0;
    int j= temp.size()-1;
    while(i<j){
        if(!temp.get(i).equals(temp.get(j))){
            return false;
        }
        i++;
        j--;
    }
return true;*/



public ListNode reverse(ListNode head){
    if(head==null||head.next==null){
        return head;
    }
    ListNode last=reverse(head.next);
    head.next.next=head;
    head.next=null;
    return last;
   }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
ListNode slow= head;
ListNode fast=head;
ListNode prev =new ListNode(0);
while(fast!=null&&fast.next!=null){
    fast=fast.next.next;
    prev=slow;
    slow=slow.next;
    
}
ListNode tail=reverse(slow);
prev.next=null;
while(tail!=null&&head!=null){
    if(tail.val!=head.val){
        return false;
    }
    tail=tail.next;
    head=head.next;
}

return true;