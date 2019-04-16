# Arrays

# 1、思路

# 2、标准代码范例

## 3、题目

## [Rotate Image](https://leetcode.com/problems/rotate-image) -- Array

### 思路

注意是要找准每次要交换的四个数字的位置索引关系，相邻的两个点之间x+y=length的；

因为每次交换四个数字，所以把要旋转的矩阵分为四块循环即可

### 注意

矩阵是奇数与偶数时有区别，奇数的中间一条线应该只能交换一次



## [Spiral Matrix](https://leetcode.com/problems/spiral-matrix) -- Arrays

### 思路

- 一层一层的输出，使用一个step记录到了哪一层了，到下一层的条件是尾部的那个位置
- 模拟顺时针旋转的过程，记录指针现在的方向，只要出界了就按指针的下一个方向继续前进



## [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes) -- Arrays

### 思路

- Brute force: 遍历矩阵，每碰到一个0，就把其所在行和列全部变成一个给定值（该值不在矩阵的数的范围里），再遍历一次把所有给定值的数变成0，需要注意的是第一次遍历时要将除0以外的行列变成给定值（因为它还要用）
- Additional Memory: 建立行索引和列索引的列表，碰到了0，就将对应的行索引和列索引列表值设为true，然后再遍历一次更新矩阵
- No Memory：将第一行和第一列作为行索引和列索引，注意的是先要计算其是否被变成0,以及最后更新它们

### 复杂度

- Brute force：Time O((M+N)*MN) Space: O(1)
- Additional Memory: Time O(MN) Space: O(M+N)
- No Memory: Time O(MN) Space:O(1)



