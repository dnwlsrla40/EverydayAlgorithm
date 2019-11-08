// RGB 거리

/*
*   처음엔 입력값이 이해가 되지 않았다. 각 집의 rgb가 입력 첫줄인 줄 알고 그럼 최소값으로 정렬하고 작은 두 개의 값을 번갈아 칠하면 되지 않나?라고 생각하였다.
*   하지만 검색해보니 각각의 집의 rgb 값이 다른 것이었다.
*   그리고 그때부터 생각해보니 다음 집을 칠할 때 가능한 가짓 수가 이전 집의 상태에 따라 간다는 것을 깨달았다. 그리고 스터디에서 푼 문제중 이와 같은 문제가 있다는 것을 깨닫고,
*   이전 집의 상태가 다음 집을 결정하는 것이 아니라 다음 집의 상태가 이전 집의 상태를 결정하면 쉽게 풀 수 있다는 것에 도달하여 풀었다.
*   그래서 다음 집이 정해지면(R) 그 이전 집의 색은 (G,B) 중 최소값의 색으로 칠해져야 한다는 것을 이용하였다.
*/

// 제출 결과[메모리: 13668KB 시간: 88ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][3];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            String[] Input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(Input[0]);
            cost[i][1] = Integer.parseInt(Input[1]);
            cost[i][2] = Integer.parseInt(Input[2]);
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        for (int i =2 ; i <= n ; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + cost[i][2];
        }
        System.out.println(Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2])));
    }
}
