package demos.basics;

public class VarArg {

    public static void main(String[] args) {
        VarArg varArg = new VarArg();
        System.out.println(varArg.sum(1,2,3,4,5,6));

        int[] nums1 = {3,5};
        System.out.println(varArg.sum(nums1));
        System.out.println(varArg.sum(1, 7));

    }
    public int sum(int... nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        return sum;
    }
    public int sum(int n1, int n2) {

        return n1 + n2;
    }
}
