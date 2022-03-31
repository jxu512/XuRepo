/*
https://leetcode.com/problems/integer-to-roman/

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

with,

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
*/
package demos.general;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        
        int len =13;
        int[] roman= {1000, 900, 500,400, 100, 90,  50, 40,  10,  9,   5,  4,   1 };
        String[] str={"M",  "CM","D","CD","C", "XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int n1=num;
        int n2=0;
        
        for(int i=0;i<len;i++) {
            n2=n1/roman[i];
            n1=n1-n2*roman[i];
            while(n2-->0) sb.append(str[i]);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	int n = Integer.parseInt(args[0]);
    	System.out.println(intToRoman(n));
    }
}