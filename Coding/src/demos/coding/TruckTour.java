package demos.coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class ResultTruck {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
        int n = petrolpumps.size();
        long sumP=0;
        long sumD=0;
        boolean startOK=true;
        for(int i=0;i<n;i++) {
            sumP=0;
            sumD=0;
            startOK=true;
            for(int k=i;k<n+i;k++) {
                sumP+=petrolpumps.get(k%n).get(0);
                sumD+=petrolpumps.get(k%n).get(1);
                if(sumP<sumD) { startOK=false;break;}
            }
            if(startOK) return i;
        }
        return -1;
    }
}
public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] petrolpumpsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> petrolpumpsRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowTempItems[j]);
                petrolpumpsRowItems.add(petrolpumpsItem);
            }

            petrolpumps.add(petrolpumpsRowItems);
        }

        int result = ResultTruck.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
