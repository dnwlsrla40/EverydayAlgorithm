import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Arrays.sort 사용 (정답으로 쳐줌)
public class Java_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] arr_N;
        N = Integer.parseInt(br.readLine());
        arr_N = new int[N];
        for(int i=0; i<N; i++){
            arr_N[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr_N);

        for(int i=0; i<N; i++){
            System.out.println(arr_N[i]);
        }
    }
}


