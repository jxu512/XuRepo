package demos.dp;

public class LargestSquare {

    public int maximalSquare(char[][] matrix) {
        int len=matrix.length;
        int wid=matrix[0].length;
        int[][] dp = new int[len][wid];
        // Square of size 1
        for(int i=0;i<len;i++)
            for(int j=0;j<wid;j++)
                if(matrix[i][j]=='1') dp[i][j]=1;
        // Square of size k: 2-min(len,wid)
        int min=len<wid?len:wid;
        for(int k=2;k<=min;k++){
            for(int i=0;i<=len-k;i++)
                for(int j=0;j<=wid-k;j++) {
                	if(dp[i][j]>0) {
	                	int s=dp[i][j]; // Current size
	                	if(dp[i+1][j+1]==k-1&&matrix[i][j+s]=='1'&&matrix[i+s][j]=='1') dp[i][j]++;
                	}
                }
        }
        // Find largest from sp
        int max=0;
        for(int i=0;i<len;i++)
            for(int j=0;j<wid;j++)
                if(max<dp[i][j]) max=dp[i][j];
        return max*max;
    }
    
    public static void main(String[] args) {
    	
    	char[][] c=
    		{ {'1','1','1','1','1','1'},{'1','1','1','1','1','1'},{'1','1','1','1','1','1'} };
    		//{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    	LargestSquare s = new LargestSquare();
    	System.out.println(s.maximalSquare(c));
    }
}