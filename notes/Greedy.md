# Greedy

# 1、思路

# 2、标准代码范例

## 3、题目

## [Jump Game](https://leetcode.com/problems/jump-game) -- Backtracking, DP Top-down, DP Bottom-up, Greedy

### Greedy

每次往前找，找到了局部最前面的满足条件的点就更新一次pos，看能不能更新到起点。



### 复杂度分析

- 时间复杂度：one-pass所以为O(n)
- 空间复杂度：O(1)



## [Gas Station](https://leetcode.com/problems/gas-station) -- Greedy

### 思路

设置一个sum，从第一个车站开始sum+=(gas[i]-cost[i])，如果sum小于0了，则肯定该点不能作为起点，且该点到迭代至的点中间的所有点也不能作为起点

### 复杂度

Time complexity: O(N)

Space complexity: O(1)