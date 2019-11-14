// 오르막 수

/*
*   예전에 푼 줄어들지 않아와 같다.
*   i는 자릿 수 이고, j는 이전에 온 수 이다. 따라서 그 다음 수는 이전수보다 커야하므로 k를 통해 비교해서 넣어준다.
*   줄어들지않아와의 차이는 이 문제에서는 10007로 나누어서 int형으로 나타낼 수 있다는 것이다.
*/

// 제출 결과[메모리: 12960KB 시간: 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11057 {
    static int num = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        int sum = 0;
        for(int i=0; i<10; i++)
            dp[1][i]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < 10 ; j++) {
                for (int k = 0; k <=j ; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= num;
                }
            }
        }
        for (int i = 0; i < 10; i++)
            sum += dp[n][i];
        System.out.println(sum % num);
    }
}
