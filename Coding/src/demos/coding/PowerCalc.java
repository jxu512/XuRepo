package demos.coding;

public class PowerCalc {
		
	/**
	 * 	
	 * @param args
	 */
	public static void main(String[] args) {

		PowerCalc p = new PowerCalc();
		System.out.println(p.powOf(2, 5));
		}
		/**
		 * 
		 * @param x
		 * @param n
		 * @return
		 */
	    public double powOf(double x, int n) {
	        
	        if(n==0) return 1;

	        if(n<0) {
	            x=1/x;
	            n*=-1;
	        }
	        
	        double result = 1.0;
	        while(n>0) {
	            if(n%2==1) result *= x;
	            x *= x;
	            n /= 2;
	        }
	        return result;
	    }
}
