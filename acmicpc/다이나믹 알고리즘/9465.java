// 스티커

/*
*   하나의 스티커를 고르면 그 좌,우,아래가 안되므로 가능한 것은 전전(i-2) 혹은 후후(i+2), 대각선 중에 값이 큰것을 고르면 된다고 생각
*   바텀 업 방식으로 기존에 사용하던 방식을 따라서 사용
*/

// 제출 결과[메모리 : 168492KB 시간 : 656ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        while(Tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n+1][2];
            int[][] dp = new int[n+1][2];
            for (int i = 0; i < 2; i++) {
                String[] Input = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    sticker[j][i] = Integer.parseInt(Input[j-1]);
                }
            }

            dp[1][0] = sticker[1][0];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i-1][1],Math.max(dp[i-2][0],dp[i-2][1])) + sticker[i][0];
                dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-2][0],dp[i-2][1])) + sticker[i][1];
            }

            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }
    }
}
