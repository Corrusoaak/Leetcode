class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
        	char[] char_array=strs[i].toCharArray();
        	Arrays.sort(char_array);
        	String ordered_word=new String(char_array);
            
        	if(!map.containsKey(ordered_word)){
        		map.put(ordered_word,new ArrayList<>());   // 这里很简化了，如果不存在先插入一个空list再加元素进去
        	}
        	map.get(ordered_word).add(strs[i]);
        }
        	// 可以直接用values创建对象，因为是Collections类;

        return new ArrayList<>(map.values());
    }
}