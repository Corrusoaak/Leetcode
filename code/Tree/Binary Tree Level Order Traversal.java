/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Iterative
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.offer(root);  // offer满时返回false，add异常，put阻塞
        List<List<Integer>> res=new ArrayList<>();
        while(!nodes.isEmpty()){
            int size=nodes.size();
            List<Integer> list=new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode cur=nodes.poll();  // poll空时返回null，remove异常，take阻塞
                list.add(cur.val);  // peek空时返回null，element异常
                if(cur.left!=null)nodes.offer(cur.left);
                if(cur.right!=null)nodes.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}
// Recursive
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelorder(root,0);
        return res;
    }
    private void levelorder(TreeNode node,int level){
        if(node==null)return;
        if(level>=res.size())res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        levelorder(node.left,level+1);
        levelorder(node.right,level+1);
    }
}