# Backtracking

## 1、思路

回溯是一种比穷举好一点的算法，但是相比于穷举，回溯算法会在solution判断为不符合条件时，会回到之前的step里去另一条path继续遍历。

因此，回溯算法一定要储存好路径的当前状态，递归函数的参数里要存储（1）当前状态的值（2）已经部分得到的解

回溯算法多用于：

- 需要搜索所有路径的题目（类似DFS）
- 需要返回所有可能解而不是求一个简单的值的题目





## 2、标准代码示例



```java
void backTracking(T solution, T cur_state){
    if(cur_state is over){
        return solution;
    }
    for(path: paths){
        Define and calculate next_state, next_solution; 
        backTracking(next_solution,next_state);
    }

}
```



## 3、题目

## [Generate Parentheses](https://leetcode.com/problems/generate-parentheses) -- backtracking

### 思路

使用Backtracking逐步探索序列，想要产生括号的所有解，必须知道满足的条件，即每次更新String时，左括号的个数一定要大于等于右括号，如果不满足，则切掉此String换下一个



## [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number) -- Backtracking

### 思路

先根据号码和对应的字母设置Map，然后根据digits进行回溯，每获得一个数字就divide path

### 注意

可以用str.substring(i,i+1)来代替str.charAt(i)，尽量不使用char或者character形式而只用string处理



## [Permutations](https://leetcode.com/problems/permutations) -- Backtracking

### 思路

拿ArrayList表示现在的矩阵的状态，每次拿一个，就从这个矩阵里面删除一个

### 注意

一定要新建ArrayList放入backtracking函数中



## [Jump Game](https://leetcode.com/problems/jump-game) -- Backtracking, DP Top-down, DP Bottom-up, Greedy

### Backtracking

正常的往前跳，在回溯函数中记录现有的位置，遍历所有能跳的路径，如果跳到了终点则返回true

### 复杂度分析

- **回溯算法的时间复杂度即为能够遍历的所有路径的数量**，在这道题中每个位置都可以选择去还是不去，所以是O(2^n)
- **回溯算法的空间复杂度和迭代的次数有关，即最长路径的长度**，在此题中最长路径就是每个位置都走，为O(n)



## [Subsets](https://leetcode.com/problems/subsets) -- BackTracking

### 思路

就是backtracking的最简短用法咯

### 总结

backtracking很适合找所有解，以及在找的时候如果是返回List的格式，一定要注意新建list，否则指针传递会乱掉



## [Word Search](https://leetcode.com/problems/word-search) -- BackTracking

### 思路

backtracking的函数目的：判断该位置的值是否是String现在的值，如果是，则下一步去判断它上下左右的四个值是不是String的下一个值

### 总结

对于上下左右的行走，以及顺时针逆时针的行走遍历，可以设置int\[\]\[\] dirs={{1,0},{-1,0},{0,1},{0,-1}}这种来方便编程，以及BackTracking的函数一定要以当前的状态考虑，设置条件。



## [Surrounded Regions](https://leetcode.com/problems/surrounded-regions)  -- DFS，BFS， Union Find

### 思路

基础思路就是遍历2D board，当发现有O时就开始进行搜索（可以用DFS或BFS），通过搜索四个方向的相邻cell进行递归，判断该区域内的O是否属于region

但是，这其中的难点在于：在判断下一个O的时候，之前该区域的O需要标记，否则会出现环（或者说是重复探索），所以需要标记已搜索的cell，我们用“$”来标记。当该区域判断为(非)可行区域时，需要重新搜索一次将标记的单元替换为真正的O或X记号。（千万不要直接用X标记走过的路然后靠着递归结束的时候重修修正，因为DFS一次只能搜索一条路径，可能该路径是符合条件的而别的路径不符合，我就是死在这上面改了很久代码QAQ）

### 复杂度

Time complexity: 从DFS的角度来看，我们只要遍历完整图即可，为O(MN)

Space complexity: 最长路径也可以一次走完整幅图，为O(MN)

### 总结

DFS没有写，应该也练习一下。以及像Word Search 一样注意可以用dirs优化代码



## [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning) -- BackTracking

### 思路

每次分割一个String，判断是否是palindrome，如果是就递归。只要写好isPalindrome函数和backtracking函数即可

### 复杂度

Time complexity: 因为最多可能会每个地方都能分割，所以worst case是O(2^N)

Space complexity: 一次性最多递归N次（因为String只有这么长），所以是O(N)



## [Number of Islands](https://leetcode.com/problems/number-of-islands) -- DFS，BFS

### 思路

和Surrounded regions很像，但是更简单的题，因为不用判断islands是否是surrounded，只要计数即可，所以也不用标记“$”



