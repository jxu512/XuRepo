/*
Given an integer , find each  such that:
x<=x<=n
n+x = x xor n
where  denotes the bitwise XOR operator. Return the number
 */

package demos.hackerrank;

public class SumXorFast {
    public static long sumXor(long n) throws Exception {
        // Write your code here

        long count = 0L;
        while(n != 0){
            count += (n%2 == 0)?1:0;
            n/=2;
        }
        count = (long) Math.pow(2,count);
        return count;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(sumXor(5));
    }
}
