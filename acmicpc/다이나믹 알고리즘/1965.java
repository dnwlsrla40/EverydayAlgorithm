// 상자 넣기

// 제출 결과[메모리: 13396KB 시간: 104ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bag = new int[n+1];
        int[] dp = new int[n+1];
        int max = 0;
        String[] Input = br.readLine().split(" ");

        for (int i = 1; i <= n ; i++) 
           bag[i] = Integer.parseInt(Input[i-1]);

        for (int i = 1; i <= n; i++) {
            dp[i]=1;
            for (int j = 1; j < i; j++) {
                if(bag[j]<bag[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j]+1;
            }
            if(max<dp[i]) max=dp[i];
        }
        System.out.println(max);
    }
}
