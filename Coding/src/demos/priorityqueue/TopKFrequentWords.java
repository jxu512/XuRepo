/*
https://leetcode.com/problems/top-k-frequent-words/

 */
package demos.priorityqueue;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = { "the", "weather", "is","good","is","it","good","it","is"};
        System.out.println(topKFrequent(words,3));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (e1,e2)-> e1.getValue() != e2.getValue() ?
                        e2.getValue() - e1.getValue() : e1.getKey().compareTo(e2.getKey())

        );
        queue.addAll(map.entrySet());
        for (int i=0;i<k;i++) result.add(queue.poll().getKey());
        return result;
    }
}
