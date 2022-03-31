/*
https://leetcode.com/problems/replace-words/

Sample:
["cat","bat","rat"]
"the cattle was rattled by the battery"

["a", "aa", "aaa", "aaaa"]
"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
*/
package demos.general;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
	
	public static void main(String[] args) {
		List<String> d = Arrays.asList("a", "aa", "aaa", "aaaa");
		String s = "baba a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		ReplaceWords r = new ReplaceWords();
		String newSentence = r.replaceWords(d, s);
		System.out.println(newSentence);
	}
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        createTrie(dictionary,root);
        String[] words=sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String w:words) {
            String prefix=searchTrie(w,root);
            if(prefix==null) sb.append(w);
                else sb.append(prefix);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    private void createTrie(List<String> d, Trie root){
    	for(String s:d) {
    		Trie cur=root;
            char[] ch=s.toCharArray();
            for(char c:ch) {
                if(cur.child[c-'a']==null) cur.child[c-'a']=new Trie();
                cur=cur.child[c-'a'];
            }
            cur.word=s;
        }
    }
    private String searchTrie(String w, Trie root){
        	Trie cur=root;
           char[] ch=w.toCharArray();
            for(char c:ch) {
                if(cur.child[c-'a']!=null) {
                	cur=cur.child[c-'a'];
                    if(cur.word!=null) return cur.word;
                }
                else return null;
            }
            return null;
    }

}
class Trie{
    Trie[] child=new Trie[26];
    String word;
}
