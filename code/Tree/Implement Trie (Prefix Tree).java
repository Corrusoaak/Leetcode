
class Trie {

    /** Initialize your data structure here. */
    private boolean isWord;
    private HashMap<Character,Trie> nexts;

    public Trie() {
        nexts= new HashMap<>();
        isWord=false;        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character,Trie> map=nexts;
        for(int i=0;i<word.length();i++){
            if(map.get(word.charAt(i))==null){
                Trie new_trie=new Trie();
                map.put(word.charAt(i),new_trie);    
            }
            Trie cur_trie=map.get(word.charAt(i));
            map=cur_trie.nexts;
            if(i==word.length()-1)cur_trie.isWord=true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character,Trie> map=nexts;
        for(int i=0;i<word.length();i++){
            if(map.get(word.charAt(i))==null){
                return false;
            }
            Trie cur_trie=map.get(word.charAt(i));
            map=cur_trie.nexts;
            if(i==word.length()-1){
                return cur_trie.isWord;
            }
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        HashMap<Character,Trie> map=nexts;
        for(int i=0;i<prefix.length();i++){
            if(map.get(prefix.charAt(i))==null){
                return false;
            }
            map=map.get(prefix.charAt(i)).nexts;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */