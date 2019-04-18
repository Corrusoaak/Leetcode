# Dynamic Programming

# 1、思路

# 2、标准代码范例

- Top-down

```java
enum Index{
    GOOD,BAD,UNKNOWN
};
Index[] memo=new Index[s.length()];

boolean solution(){
//初始化memo
    for(int i=0;i<memo.length;i++){
        memo[i]=Index.UNKNOWN;
    }
    memo[0]=Index.GOOD;

    // 递归开始
    dpTopDown(s,s.length());    
}

boolean dpTopDown(String s, int index){
    //查询memo table
    if(memo[index]!=Index.UNKNOWN)return memo[index]==Index.GOOD?true:false;
    
    //可能的边界条件，但应该没有，因为初始化了memo[0]
    //...
    
    //进行递归，并更新memo[Index]
    int new_index;
    if(dpTopDown(s,new_index)){
        memo[index]=Index.GOOD;
        return true;
    }else{
        memo[index]=Index.BAD;
        return false;
    }
} 

```

- Bottom-Up：因为计算大的值之前，小的值已经都计算好了，所以不用写Unknown

```java


boolean solution(){
    
    //初始化memo，和边界值
    boolean[] memo=new boolean[s.length()];
	memo[0]=true;
    
    for(int i=0;i<s.length();i++){
    	//更新memo
        memo[i]=true or false;
    }
}
```







## 3、题目

## [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) -- Dynamic Programming

### 思路

每次固定一个中心点，针对这个中心点去思考palindromic怎么增大，也是设置两个begin, end的index，P(i-1,j+1)=P(i,j) only if char(i-1)==char(j+1)

### 注意

- 有两种类型的中心点，比如aba和abba。要同时计算这两种类型的中心点的palindrome的长度。
- 通过计算得到的max_length来更新全局的begin和end时，不需要使用center+Math.ceil((len-1)/2)这种方法，如果center靠左就是begin=center-(length-1)/2, end=center+length/2。这种计算方法在解决Binary Search的时候也是一样的。如果必须要使用Math.ceil函数的话，一定要记得强制类型转换。



## [Jump Game](https://leetcode.com/problems/jump-game) -- Backtracking, DP Top-down, DP Bottom-up, Greedy

### DP Top-down和DP Bottom-up

动态规划的思路，是要考虑每一步如何由前几步得到，因此这道题要转换观念，位置0其实是要求的最后一步，而终点其实是第一步，我们要计算在位置i下是否能够跳到终点can_jump[i]

本质上来讲，它们的计算公式都是

can_jump[pos]=can_jump[pos+1] || can_jump[pos+2] ||... || can_jump[max_pos]

- Top-down的方法：其实是一种优化的backtracking，它们的**共同点是都需要写遍历**，但**不同点**是：backtracking需要将每一条路径都遍历，而Top-Down使用了memoization策略，为每一步存储了是否已经到了的值，如果已经算过了该点，就不用重复计算，直接从memo里面取值。

  因此，Top-down在存储值时要多写一个UNKNOWN的参数，在递归时判断其是否被计算过，如果被计算过就直接返回值，否则进行下一步递归。

- Bottom-up的方法：和Top-down相同的是也需要memo存储值，但是不需要判断是否被计算了（因为自底向上的一定会之前被计算)，另外的不同点是写迭代而不是递归，每次向上部迭代计算。



### 复杂度分析

- Top-down时间复杂度：因为是查memo来看了，总共n个位置，最远的位置要查后n-1个位置的值，所以是O(n^2)
- Top-down空间复杂度：即迭代最大次数和memo的和，O(n+n)=O(n)
- Bottom-up时间复杂度：同Top-Down
- Bottom-up空间复杂度：memo的值O(n)



## [Maximum Subarray](https://leetcode.com/problems/maximum-subarray) -- DP，Divide and Conquer

### 思路

DP: dp(i)为以索引i为结尾的子列的最大值，则dp(i)=max(dp(i-1),0)+ nums[i]

### 复杂度

DP: Time O(N) Space O(1)

### 注意

计算以i开头的序列的最大值时，要把初始max设置为nums[i]而不是0



## [Word Break](https://leetcode.com/problems/word-break) -- DP

### 思路

这道题和Jump Game的写法几乎一模一样，memo[i]表示的是string的[0,i)范围的子串是否是wordBreak

### 复杂度

Time complexity: O(N^2)，扫描memo O(N)* 每次要查询前面n-1个memo的值O(N)

Space complexity: O(N),memo表



## [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray)  -- DP

### 思路

maximum subarray的变式，同样是将dp[i]作为以i结尾的最大product，但是更新dp[i]的时候要注意，要同时维护绝对值最大的正数和负数值，同时更新这3个值

### 注意

实际操作中可能没有正值或负值，只要将原来的两个数和nums[i]比较取最大和最小的即可

~~~java
last1*=nums[i];
last2*=nums[i];
int tmp1=Math.max(Math.max(last1,last2),nums[i]);
int tmp2=Math.min(Math.min(last1,last2),nums[i]);
last1=tmp1;
last2=tmp2;
~~~

