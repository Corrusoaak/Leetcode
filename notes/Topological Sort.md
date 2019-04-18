# Topological Sort

## 1、原理

给出有向无环图（DAG）的一种排序方式，可以通过改良DFS与BFS实现

算法流程：

 - 初始化每个点的入度，并根据给定的边来
 - 选取所有入度为0的点放入队列
 - 每次弹出一个点，并将其连接的点的入度-1，同时判断该点是否已经为0并放入队列
 - 重复上一过程直到队列中无点
 - 检查是否所有点入度都为0（或者输出排序顺序）



## 2、题目（即为标准范例代码，只写了BFS方法）

## [Course Schedule](https://leetcode.com/problems/course-schedule)

## [Course Schedule II](https://leetcode.com/problems/course-schedule-ii)  

