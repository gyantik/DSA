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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // If list has less than 3 nodes, critical points are not possible
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        // prev points to previous node, curr points to current node
        ListNode prev = head;
        ListNode curr = head.next;

        // Position of current node (1-based indexing)
        int i = 2;

        // To store positions of critical points
        int prevCriticalpos = -1;
        int firstCriticalpos = -1;

        // To store minimum distance between consecutive critical points
        int minDistance = Integer.MAX_VALUE;

        // Traverse till second last node
        while (curr.next != null) {

            // Check if current node is a critical point
            // Local minima or local maxima
            boolean isCritical =
                (curr.val < prev.val && curr.val < curr.next.val) ||
                (curr.val > prev.val && curr.val > curr.next.val);

            if (isCritical) {
                // If this is the first critical point found
                if (firstCriticalpos == -1) {
                    firstCriticalpos = i;
                } else {
                    // Update minimum distance
                    minDistance = Math.min(minDistance, i - prevCriticalpos);
                }
                // Update previous critical point position
                prevCriticalpos = i;
            }

            // Move pointers and index forward
            i++;
            prev = curr;
            curr = curr.next;
        }

        // If less than two critical points were found
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        // Return minimum and maximum distance
        return new int[]{
            minDistance,
            prevCriticalpos - firstCriticalpos
        };
    }
}
