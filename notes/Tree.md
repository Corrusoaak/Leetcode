## [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal) -- Tree

### 思路

- Recursion: 很简单

- Iteration： **树的迭代方法大多需要用栈**，中序遍历是因为先要用栈去存储该结点，然后去找后面的左子树的结点。当左子树结点全部打印了，再从栈中pop出该结点

  具体思考（针对单独的某个结点）：

  - 方法一（GT）：对于该节点，我们将其存入栈中，并一直去寻找它的左子树的结点，并全部推入栈中，再从栈中返回上一个结点，同时写入结果中，最后将该节点指向其右子树的结点
  - 方法二（Mine）：对于该节点，考虑它产生的情况：（1）被栈推出的，那么就写入结果，并指向右子树（2）向下指出来的，那么就推入栈，并指向左子树。

  - 个人觉得，自己的方法更Intuitive

### 复杂度

- Recursion： Time O(N) since T(N)=2T(N/2)+1 (也可以理解为每个结点打印一次) Space：O(N) for worst case, O(logN) for average case
- Iteration：Time O(N+N)=O(N) 为被推入栈的次数+被打印的次数 (因为对于任意结点，所有结点在被打印前都要检测其是否有左子树，即都要被推入栈一次，且被打印一次) Space：O(N)



## [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) -- Binary Search Tree

### 思路

二分搜索树的概念：

（1）左子树<该节点<右子树

（2）左子树与右子树都为二叉搜索树

然而，解题不是直接使用第一个条件的....

无论是迭代还是递归，都是对每一个结点设置upper bound和lower bound，如果满足 lower<node.val<upper，则该节点符合条件，再去调查它的子节点是否都符合条件

- Recursion：如上所述，左子树的条件是 lower<left.val<node.val，右子树的条件是 node.val<right.val< upper
- Iteration：
  - 方法一：为节点，upper bound和lower bound分别设置三个栈，每次检查该节点是否符合条件，再把它左右子树和其对应的upper，lower bound推入栈，下一个节点由栈pop得到
  - 方法二：用**中序遍历**遍历该二叉搜索树，遍历的结果必须是递增的，这个关系很有趣！

### 复杂度

- Recursion：同中序遍历
- Iteration：
  - 方法一：Time O(N) （while 循环，一次判断一个结点） Space: 一次添加往栈里加两个加点而拿出一个，最终会有O(N)个
  - 方法二：同中序



### Notes:

使用栈的方法时，要注意while条件是栈不为空且当前结点不为null，而且**一开始要判断当前结点是否为null，是null就要pop出一个新的结点(这是写树，链表等高级结构时都要先判断的条件！！！！)**