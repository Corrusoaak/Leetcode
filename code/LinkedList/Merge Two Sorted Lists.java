/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        boolean is1=true;
        while(l1!=null && l2!=null){
        	if(l1.val<l2.val){
        		cur.next=l1;
        		cur=l1;
        		l1=l1.next;
        	}else{
        		cur.next=l2;
        		cur=l2;
        		l2=l2.next;
        	}
        }
        cur.next= (l1==null?l2:l1);

        return dummy.next;

    }
}