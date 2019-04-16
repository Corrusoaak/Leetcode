# LinkedList

# 1、思路

# 2、标准代码范例

## 3、题目

## [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)  -- Linked List

### 思路

其实这个题很无聊，一个指针two pass就可以找到该Node，想要完成one pass就设置两个距离N的指针就ok

### 注意

在处理linked list时，一定要设置dummy，将其next指向头结点，这样可以避免边界条件（比如头结点被删掉了，或者list最终变为空），最终返回头结点的时候也是返回dummy.next

```java
ListNode dummy=new ListNode(0);
dummy.next=head;

return dummy.next;
```

在遍历结点时，循环条件一定是cur_node!=null而不是cur_node.next!=null !!!! 一定要让让指针最后指到null上去，原因和设置dummy是一样的。

```java
while(cur_node!=null){
    cur_node=cur_node.next;
}
```



## [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) -- Linked List

### 思路

建立一个dummy和current_node，对比两个列表当前的值，哪个小就指哪个，比将其cur.next=it, cur=it, it=it.next。如果空了的话，就指向里一个列表当前值



## [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer) -- Linked List, HashTable

### 思路

存一个原节点到新节点的HashMap，先简历所有的新点装进去，然后再匹配next和random

### 复杂度

Time Complexity: 遍历O(N) * HashMap搜索O(1) 

Space Complexity: O(N)

