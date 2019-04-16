/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(0,null,null);
        dummy.next=head;
        Node cur=dummy;
        List<Node> nodes=new ArrayList<>();

        // create new nodes
        while(cur!=null){
            Node copy_cur=new Node(cur.val,null,null);
            nodes.add(copy_cur);
            cur=cur.next;
        }
        
        // copy next attribute
        for(int i=1;i<nodes.size();i++){
            nodes.get(i-1).next=nodes.get(i);
        }

        // copy random attribute
        cur=dummy;
        copy_cur=nodes.get(0);
        while(cur!=null){
            Node cur_random=cur.random;
            int length=0;
            while(cur_random!=null){
                length++;
                cur_random=cur_random.next;
            }
            if(length!=0)copy_cur.random=nodes.get(nodes.size()-length);
            cur=cur.next;
            copy_cur=copy_cur.next;
        }

        return nodes.get(0).next;       

    }
}


class Solution {
    public Node copyRandomList(Node head) {
        Node cur=head;
        Map<Node,Node> nodes=new HashMap<>();

        // create new nodes
        while(cur!=null){
            Node copy_cur=new Node(cur.val,null,null);
            nodes.put(cur,copy_cur);
            cur=cur.next;
        }
        
        // copy random attribute
        cur=head;
        while(cur!=null){
            nodes.get(cur).next=nodes.get(cur.next);
            nodes.get(cur).random=nodes.get(cur.random);
            cur=cur.next;
        }
        return nodes.get(head);       

    }
}