package demos.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      
        Queue<String> queue = new LinkedList<String>();
        
        int depth = findWord(beginWord, endWord,wordList, queue);
        System.out.println("Length: "+depth);
        return depth;
    }
    
    private int findWord(String currentWord, String endWord,List<String> wordList,Queue<String> queue) {
        
        queue.add(currentWord);
        int depthCount=queue.size();
        int depth=1;
        while(!queue.isEmpty()) {
            
            String word = queue.remove();
            List<String> match = matchWords(word,wordList);
            for(int i=0;i<match.size();i++) {
                String next = match.get(i);
                if(next.equals(endWord)) return depth+1; // Move up one level
                queue.add(next);
            }
            if(--depthCount==0) { 
            	depth+=1; 
            	depthCount=queue.size();
            }
        }
        return 0;
    }
    private List<String> matchWords(String word, List<String> wordList){
        
        List<String> match = new ArrayList<String>();
        for(int i=0;i<wordList.size();i++) {
            int count=0;
            for(int j=0;j<word.length();j++)
                	if(word.charAt(j)!=wordList.get(i).charAt(j)) count ++;
            if(count==1)  match.add(wordList.get(i));
        }
        wordList.removeAll(match);
        return match;
    }
    
    public static void main(String[] args) {
    	
    	WordLadder ladder = new WordLadder();
    	/*
    	String begin="hit";
    	String end="cog";
    	String[] arr = {"hot","dot","dog","lot","log","cog"};
    	*/
    	/*
    	String begin="a";
    	String end="c";
    	String[] arr = {"a","b","c"};
    	*/
    	//*
    	String begin="leet";
    	String end="code";
    	String[] arr = {"leet","code","lest","leet","lose","code","lode","robe","lost"};
    	//*/
    	List<String> list = new ArrayList<String>();
    	list.addAll(Arrays.asList(arr));
    	ladder.ladderLength(begin, end, list);
    }
}