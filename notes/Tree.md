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





## [Symmetric Tree](https://leetcode.com/problems/symmetric-tree)  

## 思路

- Recursion: 判断两个对称的节点是否相等，如果相等则判断左节点的右子树和右结点的左子树是否相等，以及左节点的左子树和右结点的右子树是否相等
- Iterative：同样的检测方法，可以建立stack，每次存两个相邻的节点，然后每次也推出两个节点比较大小



## [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal) -- BFS, Level Order Traversal

## 思路

- Recursion：递归函数中设置一个level，如果没有就加一个空的list，然后在这一层的res上添加该节点的值，最后再递归其左节点和右结点（保证每层左节点一定在右结点前面）
- Iteration：每一层迭代时，设置一个队列（先进先出），把迭代的该节点的左子树和右子树存入队列，然后再进行下一层迭代（每层迭代前，都计算一下该层的节点数量）

## 

## [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal)  -- Level Order Traversal

## 思路：仍然是层次遍历，只是加了一个反向层次遍历

- Recursion：递归里面多加一个boolean参数，是从左向右递归还是从右向左，level%2==0 or 1 的时候判断是否打印
- Iteration：设置两个队列，判断一下打印打哪一个即可



## [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) 

## 思路

对于中序遍历的结果，只要每一次找到根节点，然后左右分别就是左子树和右子树，然后再查找前序遍历中的左子树和右子树位置，建立下一层递归（通过设置左右子树的前后索引）

## 注意

判断该节点是否为null的情况，是通过看左索引是否大于右索引



