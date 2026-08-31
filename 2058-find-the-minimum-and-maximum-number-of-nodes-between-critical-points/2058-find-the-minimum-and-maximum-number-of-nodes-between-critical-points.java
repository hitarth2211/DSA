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
        int[] res = {Integer.MAX_VALUE, -1};
        ListNode dummy = head.next;
        ListNode prev = head;
        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;
        while(dummy.next != null) {
            if(prev.val < dummy.val && dummy.val > dummy.next.val) list.add(counter);
            else if(prev.val > dummy.val && dummy.val < dummy.next.val) list.add(counter);
            dummy = dummy.next;
            prev = prev.next;
            counter++;
        }
        if(list.size() != 0) {
            res[1] = list.get(list.size() - 1) - list.get(0) > 0 ? 
            list.get(list.size() - 1) - list.get(0) : -1;
        }

        if(list.size() > 1) {
            for(int i = 1; i < list.size(); i++) {
                res[0] = Math.min(
                        res[0],
                        list.get(i) - list.get(i - 1) > 0 ?
                        list.get(i) - list.get(i - 1) : -1
                );
            }
        }
        if(res[0] == Integer.MAX_VALUE) res[0] = -1;
        return res;
    }
}