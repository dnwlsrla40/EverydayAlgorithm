// 퇴사

/*
*   dp는 각 날에 벌수 있는 최대 금액을 두고 어떠한 날에 상담을 하기로 한 경우, 
*   상담 기간이 끝나는 날의 값을 현재 날부터 그 상담 기간이 끝난 뒤의 값(안했을 경우 최댓값)과 
*   하기로한 날까지의 최대 값과 오늘 수락한 날의 상담 비용을 더한 값 중 큰 값으로 설정한다.
*/

// 제출 결과: [메모리:12944KB 시간: 72ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+6];
        int[] T = new int[n+6];
        int[] P = new int[n+6];
        int max=0;
        for (int i = 1; i <= n; i++) {
            String[] Input = br.readLine().split(" ");
            T[i] = Integer.parseInt(Input[0]);
            P[i] = Integer.parseInt(Input[1]);
        }

        for (int i = 1; i <= n+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
