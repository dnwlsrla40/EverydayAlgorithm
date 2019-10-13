// 2Xn 타일링 2
// 기존의 타일 문제에서 2칸의 타일이 남았을 때 1X2 타일이 올 수있는 경우와 2X2 타일이 올 수 있는 경우로 2가지이기 때문에
// 점화식을 dp[i] = dp[i-1] + 2*dp[i-2]로 정함

// 제출 결과[메모리: 12940KB 시간: 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11727 {
    static int dp[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }
}
