/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> nodes=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        nodes.offer(root);
        stack.push(root);
   		boolean is_left=false;
        while(!nodes.isEmpty()){
        	int size=nodes.size();
        	List<Integer> list=new ArrayList<>();
        	Stack<TreeNode> next_stack=new Stack<>();
        	for(int i=1;i<=size;i++){
        		TreeNode node1=nodes.poll();
        		TreeNode node2=stack.pop();
        		if(node1!=null){
        			list.add(node1.val);
        		}
        		if(node2!=null){
        			if(is_left){
        				nodes.offer(node2.left);
        				nodes.offer(node2.right);
        				next_stack.push(node2.left);
        				next_stack.push(node2.right);
        			}else{
        			    nodes.offer(node2.right);
        				nodes.offer(node2.left);
        				next_stack.push(node2.right);
        				next_stack.push(node2.left);	
        			}
        		}
        	}
        	if(list.size()!=0)res.add(list);
        	is_left=!is_left;
        	stack=next_stack;
        }
        return res;
    }
}