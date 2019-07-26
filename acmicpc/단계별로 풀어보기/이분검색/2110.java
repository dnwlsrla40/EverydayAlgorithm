import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Java_2110 {
    public static int binSearch(int[] Array, int left, int right, int routerCount) {
        int result=0;
        while(left<=right){
            int mid = (left+right)/2;
            int count=1;
            int start=Array[0];
            for(int i=0; i<Array.length; i++){
                if(Array[i]-start >= mid){
                    count++;
                    start = Array[i];
                }
            }
            if(count>=routerCount){
                result= mid;
                left = mid +1;
            } else
                right = mid-1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] InputArray = bf.readLine().split(" ");

        int houseCount = Integer.parseInt(InputArray[0]);
        int routerCount = Integer.parseInt(InputArray[1]);

        int[] houseArray = new int[houseCount];
        for(int i=0; i<houseCount; i++)
            houseArray[i] = Integer.parseInt(bf.readLine());

        Arrays.sort(houseArray);

        int left = 1;
        int right = houseArray[houseCount-1] - houseArray[0];
        int result;
        result = binSearch(houseArray, left, right, routerCount);
        System.out.println(result);
    }
}
