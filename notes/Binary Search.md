# Binary Search

## 1、原理

二分搜索的精髓在于每一次更新边界的过程中，都要保证所要求的值仍然在你所更新的边界之内。

这就和我们设置的更新边界的条件有关。

## 2、代码标准范例：



经过我个人的修改总结，伪码格式（即算法思路）为：

```java
int a,b //初始化边界
while(b>a){
    int c=(a+b)/2;  // 更新的边界
    /**
    *你的条件,并选择c=a or c=b
    **/
   
}
if(nums[a]==target){
    return a;
} // 你最终的结果，因为b=a
```



Notes：在实际写代码的时候，由于c=(a+b)/2，会偏左边一点，所以更新a或b的时候，要根据情况将更新条件写成a=c+1 或 b=c-1；这个考虑在b-a=1的情况时很容易出错，需要注意

以下提供第一题的代码作为参照：

```java
    public int search(int[] nums, int target) {
        int length=nums.length;
        int a=0,b=length-1;  
        while(b>a){
            int c=(a+b)/2;
            if(nums[c]>nums[a]){
                if(nums[a]<=target && target<=nums[c]){
                    b=c;
                }else{
                    a=c+1;
                }
            }else{
                if(nums[c+1]<=target && target<=nums[b]){
                    a=c+1;
                }else{
                    b=c;
                }
            }
        }
        if(a<length && nums[a]==target){
            return a;
        }
        return -1;
    }
```



## 3、题目

### [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)  



### [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)  

