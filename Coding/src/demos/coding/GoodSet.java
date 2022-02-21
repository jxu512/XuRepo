package demos.coding;

/* 
 Sample input
7
aab
defgab  
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
 
 */
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

class Result3 {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
    // Write your code here

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String next = treeSet.ceiling(word);
            String prev = treeSet.floor(word);
            
            if ((next != null && next.startsWith(word)) || (prev != null && word.startsWith(prev))) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
            
            treeSet.add(word);
        }
        
        System.out.println("GOOD SET");
    }

}

public class GoodSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result3.noPrefix(words);

        bufferedReader.close();
    }
}
