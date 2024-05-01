package demos.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class IcecreamParlor {
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int idx1=-1, idx2=-1;
        for (int i=0;i<arr.size()-1;i++) {
            idx1=i;
            for (int j=i+1;j<arr.size();j++) {
                if (arr.get(i)+arr.get(j)==m) {
                    idx2=j;
                    break;
                }
            }
        }
        result.add(idx1+1);
        result.add(idx2+1);
        return result;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        System.out.println(icecreamParlor(4, list));
    }
}
