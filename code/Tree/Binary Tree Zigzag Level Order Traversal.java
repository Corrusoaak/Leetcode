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

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> left_to_right=new LinkedList<>();
        Queue<TreeNode> right_to_left=new LinkedList<>();
        left_to_right.offer(root);
        right_to_left.offer(root);
   		boolean is_left=false;
        while(!nodes.isEmpty()){
        	int size=left_to_right.size();
        	List<Integer> list=new ArrayList<>();
        	for(int i=1;i<=size;i++){
        		TreeNode t1=left_to_right.poll();
        		TreeNode t2=right_to_left.poll();
        		if(is_left){
        			if(t2!=null)list.add(t2.val);
        		}else{
        			if(t1!=null)list.add(t1.val);
        		}
        		if(t1!=null){
        			left_to_right.offer(t1.left);
        			left_to_right.offer(t1.right);
        		}
        		if(t2!=null){
        			right_to_left.offer(t2.right);
        			right_to_left.offer(t2.left);
        		}
        	}
        	if(list.size()!=0)res.add(list);
        	is_left=!is_left;
        }
        return res;
    }
}

// Recursion
class Solution {
    List<List<Integer>> res=new ArrayList<>();	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levelorder(root,0,true);
        levelorder(root,0,false);
        return res;    	
    }

    private void levelorder(TreeNode node,int level,boolean is_left){
        if(node==null)return;
        if(level>=res.size())res.add(new ArrayList<Integer>());
        if((level%2==0)==is_left)res.get(level).add(node.val);
        if(is_left){
	        levelorder(node.left,level+1,is_left);
	        levelorder(node.right,level+1,is_left);
        }else{
        	levelorder(node.right,level+1,is_left);
        	levelorder(node.left,level+1,is_left);
        }
    }
}
