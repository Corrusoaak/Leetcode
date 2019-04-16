/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Iterative
class Solution {
    public Node connect(Node root) {
        Queue<Node> levels=new LinkedList<>();
        levels.offer(root);
        while(!levels.isEmpty()){
            int size=levels.size();
            Node cur=levels.poll();
            for(int i=1;i<=size-1;i++){
                Node last=cur;
                cur=levels.poll();
                if(last!=null){
                    last.next=cur;
                    levels.offer(last.left);
                    levels.offer(last.right);
                }
            }
            if(cur!=null){
                cur.next=null;
                levels.offer(cur.left);
                levels.offer(cur.right);
            }
        }
        return root;
    }
}


// Recursion 
class Solution {
    public Node connect(Node root) {
        if(root==null)return root;
        pointToNext(root.left,root.right);
        return root;
    }

    private void pointToNext(Node left,Node right){
        if(left==null || right==null)return;
        if(left.next==null){
            left.next=right;
            pointToNext(left.left,left.right);
            pointToNext(left.right,right.left);
            pointToNext(right.left,right.right);            
        } 
    }
}



