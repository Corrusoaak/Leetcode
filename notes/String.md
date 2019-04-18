# String

# 1、思路

# 2、标准代码范例

## 3、题目

## [Group Anagrams](https://leetcode.com/problems/group-anagrams)  -- String

### 思路

- anagram的字符串排序后应该相同
- anagram的每个字符出现的次数相同

### 注意

- 可以直接返回Map.values()作为ArrayList

  ```java
  return new ArrayList<>(map.values());
  ```

- 在发现该anagram不存在于Map时，应该像字典一样，先创建一个空的词典，再往里面加

  ```java
  if(!map.containsKey(ordered_word)){
  	map.put(ordered_word,new ArrayList<>()); 
  }
  map.get(ordered_word).add(strs[i]);
  ```

  

## [Roman to Integer](https://leetcode.com/problems/roman-to-integer) -- String

### 思路

一次读一个字符，如果特殊情况出现了就特殊考虑



## [Implement strStr()](https://leetcode.com/problems/implement-strstr)  -- String

### 思路

过于简单



## [Largest Number](https://leetcode.com/problems/largest-number)  -- String

### 思路

即重构比较符Comparator，可以通过将按照ab和ba的顺序转化成integer再进行比较。之后写一个sort即可

### 注意

注意如果所有String都是0的特殊情况，此时返回0