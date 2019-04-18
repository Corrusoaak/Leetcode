# Trie

## 1、原理

Trie被称为字典树，每个节点存储了该字符串的某一字符，如果有两个word共享前缀的话，它们会有共同的前缀节点，如下是存储了“see”,"pain","pa","pand","dog"五个word的Trie

![Trie](https://img-blog.csdn.net/2018061522564299?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pvaG5ueTkwMTExNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

Trie类也是一种树结构，其本质也就是一个树节点，其中属性包含了

- boolean isWord;
- HashMap\<Character,Trie\> nexts;

其中isWord需要判断该节点是否是单词的尾部（即是否是个word），nexts根据character存储了所有子节点



Trie类的方法就不难写，包括insert,search,startswith，可以直接参考例题代码



## 2、题目

## [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree)  

