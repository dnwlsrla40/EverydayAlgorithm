import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Java_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        int num_Lan = Integer.parseInt(Input[0]);
        int num_need = Integer.parseInt(Input[1]);

        int[] Lan_arr = new int[num_Lan];
        for(int i = 0; i < num_Lan; i++) {
           Lan_arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Lan_arr);
        long max = Lan_arr[num_Lan-1];
        long min = 1;
        long mid;
        while(max >= min){
            mid = (max+min)/2;
            long check = 0;
            for(int i=0; i<Lan_arr.length; i++)
                check += Lan_arr[i]/mid;
            if(check >= num_need)
                min = mid+1;
            else if(check < num_need)
                max = mid-1;
        }
        System.out.println(max);
    }
}
