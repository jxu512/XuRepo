package demos.general;

class ReverseInteger {
    public int reverse(int x) {
     
        boolean negative=false;
        if(x<0) {
            negative=true;
            x=-x;
        }
        int res=0;
        int r=0;
        while(x>0) {
            r=x%10;
            if(Integer.MAX_VALUE/10<res) return 0;
            res=res*10+r;
            x/=10;
        }
        return negative?-res:res;
    }
}