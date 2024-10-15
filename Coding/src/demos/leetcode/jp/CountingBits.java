/*
https://leetcode.com/problems/counting-bits/description/
*/
package demos.leetcode.jp;

public class CountingBits {

    // Loop
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int x = 0xffffffff;
        for (int i=0;i<=n;i++) {
            int a = x & i;
            while (a != 0) {
                if (a%2==1) res[i]++;
                a >>= 1;
            }
        }
        return res;
    }

    // dp
    public int[] countBits1(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if (n==0) return ans;

        for (int i=1;i<=n;i++) {
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }

}
