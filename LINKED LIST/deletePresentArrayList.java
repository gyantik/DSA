class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        // Store all values from nums in a HashSet for fast lookup
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        // Dummy node to handle deletion of head node easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {

            // If current node value is present in nums, delete it
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
