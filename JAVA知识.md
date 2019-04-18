# JAVA知识

## String

- 通过char[]创建：new String(char[] a,optional int offset,optional int length)
- 其他数据类型转string：tostring()
- 获取长度：**length()**
- 字符串查找：indexOf(String s) ,lastIndexOf(String s)，无则返回-1，若s为空字符串，则是分别返回0和length
- 获取指定位置字符：**charAt(int index)**
- 获取子字符串：**substring(int beginIndex, int endIndex)**
- 去除前导和尾部空格：**trim()**
- 替换：replace(char oldChar, char newChar)
- 判断开始和结束：startsWith(String prefix),endsWith(String suffix)
- 比较字符串内容是否相等：不能用==(是比较地址)，要用**equals()或者equalgnoreCase()**
- **比较大小：compareTo(str)**
- 大小写：toUpperCase()
- 分割字符串：split(String regex, optional int limit) 可以用string或正则表达式分割，比如",|."就可以同时分割，和.，limit限制分割后string个数，比如2就是最多两个string
- 格式化：String.format("%2d",5400/2)
- 字符串生成器：由于每次改变String，都要产生新的实例，内存地址都要被消耗，对系统是很大的负担，StringBuilder可以解决这个问题，append(arg)==+，insert(int offset,arg)，delete(int start,int end)



## 数组

- 数组创建时如果未直接初始化，需要分配内存；二维数组也是一样，每一维都需要

- 声明：int[] array={1,2,3} or int[] array=new int[3]; 如果只是分配内存，则初始化为0
- 长度：length，但使用foreach遍历更好
- 填充：Arrays.fill(int[] a, optional int fromIndex, optional int toIndex, int value)

- 排序：**Arrays.sort(object)**

- 复制：copyOf(arr, int newLength)，copyOfRange(arr, int fromIndex, int toIndex)




## 容器

- HashMap 继承Map接口，Set，List继承Collection接口

- Collection接口有**size(), add(obj), remove(obj or index) (只删第一个), isEmpty(), clear()** 函数，set和list都能用

- iterator()返回迭代器，Iterator   hasNext(), next()可用来迭代，返回Object，要强制类型转换

  ### New

  - **addAll()可以一次性装=Arrays.fills()**

### List

- get(int index), set(int index, Object object), indexOf()
- 有ArrayList （随机访问快）和 LinkedList （删除插入快） 
- 初始化：  List<String> list= new ArrayList<>();

### Set

- 有HashSet（每次顺序不一样），TreeSet（遍历时按照自然顺序，如果是自定义类，要实现Comparable接口，具体要重载compareTo这个函数）
- first(), last(), headSet(E toElement), subSet(E fromElement, E toElement), tailSet(E fromElement)

### Map

- **put(key, value)**, **containsKey(key)**, containsValue(value), get(key), **keySet()** 返回set, **values()** 返回collection
- 有HashMap（推荐，增删快）和TreeMap（按照键顺序输出，可以先建立Hashmap，要顺序输出时再创建TreeMap： treemap.putAll(hashmap)）



## Queue

- 初始化：使用LinkedList

~~~java
	Queue<Integer> queue=new LinkedList<>();
~~~

- offer()插入， poll()弹出空时返回null，peek()查看空时返回null



## Stack

- 初始化：

  ~~~java
  Stack<Integer> stack=new Stack<>();
  ~~~

- pop() push()







## 注意

- 只有这种Integer这类的可以为空，但为空时不能直接比，要判断是否为空

- 对于两个变量判断是否为空，可以用如下的方法

~~~java
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
~~~



## Ask

可以从输入输出问

输入的格式，大小，会不会重复

运算符会有/0

边缘情况的输出





## 数据类型转换

- String转int：Integer.parseInt(s) 或者 Integer.valueOf(s)
- int转String：“”+i 或者String.valueOf(i)
- String转float：Float.parseFloat(s)
- float转String：同int

- String转char[]：s.toCharArray()
- char[]转String: String.valueOf(cs)



## 重写数组元素比较器

~~~java
public class newStringComparator implements Comparator<String>{
		@Override
		public int compare(String a, String b){
			return -(a+b).compareTo(b+a);
		}
	}

Array.sort(arrays, new newStringComparator());
~~~

一定要注意不要写反，写的时候考虑如果a在b前面，则a<b(此时是a~b>b+a)

~~~

~~~





