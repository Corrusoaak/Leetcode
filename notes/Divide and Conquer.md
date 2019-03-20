# Divide and Conquer

## 1. 概述

分治算法就是将一个大问题划分多个相同类型的子问题，通过解决子问题来最终解决大问题的算法

## 2. 适用范围

- 大问题可以划分为**相同类型**的子问题
- 子问题的解之间可以用简单的方法进行**结合**，来得到大问题的解

## 3. 算法流程

~~~java
T solution(T[] nums){
    return subSet(nums,0,nums.length-1);
}


T subSet(T[] nums,int begin, int end){
    if(begin==end){
        return nums[begin];
    }
    int mid=(begin+end)/2;
    T left=subSet(nums,begin,mid);
    T right=subSet(nums,mid+1,end);
    return combination(left,right);
}

T combination(T A, T B){
    // some simple function
}

~~~

主要就是设计一个子函数subSet和一个combination函数，子函数每次分割问题并使用combination函数结合返回

其中在计算left和right的子函数结果时，一定要分割开（在这里是mid和mid+1），否则可能会无限循环（有两个值的时候）

## 4. 示例

14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.



~~~java
class Solution{
	public String longestCommonPrefix(String[] strs){
		if(strs.length==0){
			return "";
		}
		return divideAndConquer(strs,0,strs.length-1);
	}

	private String divideAndConquer(String[] strs,int begin,int end){
		if(begin==end){
			return strs[begin];
		}
		int mid=(begin+end)/2;
		String left=divideAndConquer(strs,begin,mid);
		String right=divideAndConquer(strs,mid+1,end);
		return commonPrefix(left,right);
	}
	private String commonPrefix(String left,String right){
		int index=0;
		while(index<left.length() && index<right.length()){
			if(left.charAt(index)!=right.charAt(index)){
				break;
			}
			index++;
		}
		return left.length()<right.length()?left.substring(0,index):right.substring(0,index);
	}

}
~~~

