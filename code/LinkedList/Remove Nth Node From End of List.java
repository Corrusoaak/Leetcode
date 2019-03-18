/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy= new ListNode(0);
    	ListNode first_ptr=dummy,second_ptr=dummy;
    	dummy.next=head;
    	for(int i=1;i<=n+1;i++){
    		second_ptr=second_ptr.next;
    	}
    	while(second_ptr!=null){
    		first_ptr=first_ptr.next;
    		second_ptr=second_ptr.next;
    	}
    	first_ptr.next=first_ptr.next.next;
    	return dummy.next;
    }
}