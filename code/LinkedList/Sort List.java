/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
    	if(head==null) return null;
    	return divide(head);
    }
    private ListNode divide(ListNode node){
    	if(node.next==null)return node;
    	ListNode mid=node,right=node;
    	while(right!=null){
    		mid=mid.next;
    		right=right.next;
    		if(right==null)break;
    		right=right.next;
    	}
    	right=node;
    	while(right.next!=mid){
    		right=right.next;
    	}
    	right.next=null;
    	return sortCombination(divide(node),divide(mid));
    }

    private ListNode sortCombination(ListNode left,ListNode right){
    	ListNode dummy=new ListNode(0);
    	ListNode cur=dummy;
    	while(left!=null && right!=null){
    		if(left.val>=right.val){
    			cur.next=right;
    			right=right.next;
    		}else{
    			cur.next=left;
    			left=left.next;
    		}
    		cur=cur.next;
    	}
    	cur.next= (left==null)?right:left;
    	return dummy.next;
    }

}