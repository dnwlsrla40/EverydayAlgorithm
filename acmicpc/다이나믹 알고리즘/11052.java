// 카드 구매하기

//dp[n]은 n개의 카드가 들어간 카드팩 가격, n-1개의 카드가 들어간 카드팩 가격 + 1개의 카드가 들어간 카드팩 가격, n-2개의 카드가 들어간 카드팩 가격 + 2개의 카드가 들어간 카드팩 가격, ... 중의 최대값이라는 것을 이용
// 제출 결과: [메모리 : 13316KB 시간 : 96ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n ; i++)
            p[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i],dp[i-j] + p[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
