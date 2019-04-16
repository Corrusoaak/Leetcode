# Two Pointer Approach

## 1、思路

基本思路是先设置一个全局的值，然后再每次指针更新的时候去看这个值是否要更新。同时要思考指针更新的条件。

双指针法可以考虑在

- 可以使用2-pass暴力求解的题目->该用one-pass
- 可以将数组重新排序的题目

同时，指针的位置请不要局限在起点，可以一个在起点一个在终点。或者别的



## 2、题目

## [3Sum](https://leetcode.com/problems/3sum) 

### 思路

先将数组排序，在每次固定一个整数nums[i]，其中一个指针指向该数后面的第一个数（最小），另一个指针指向最大的数，通过判断nums[i]+nums[j]+nums[k]<=>0来移动左右指针并找到3sum组合

### 注意

每次更新固定的数和再加入一个新的组合后，为了保证组合不重复，要更新指针到一个新的值，可以用nums[j]!=nums[j-1]来判断



## [Container With Most Water](https://leetcode.com/problems/container-with-most-water)

### 思路

将其中一个指针放在第一个隔板，一个指针放在最后一个隔板，通过比较两个指针所指隔板的高低来更新指针，逐渐递增更低的那个隔板，当那个隔板高于另一个隔板时去更新另一个隔板的指针。每次更新都判断是否容器能装更多水



## [Sort Colors](https://leetcode.com/problems/sort-colors) -- 2 pointers Approach

### 思路

- 2-pass：第一次遍历先计算每个数的个数，第二次遍历根据个数更新列表
- 1-pass（大多用 2 pointers approach实现）： 将两个指针分别指向1和2的首个位置的索引（初始设为-1），每次获取新值，若为2，则不变，若为1，则和2的指针互换位置，若为0，则和1,2的指针都互换位置并交换列表的值。需要注意的是1的指针位置在更新的时候会出现两种情况
  - 之前没有1的指针： 0 0 2 2 2 **1**    这样1的指针设置为2的指针，2的指针位置++
  - 之前有1的指针： 0 0 1 1 2 2 **1**   这样1的指针不变，2的指针++



## [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array)  -- Two Pointers Approach

### 思路

指针指向当前要改的点即可，判断值是否改变就用N[i]==N[i-1]



