// 이동하기

// dp[i][j]가 이전의 3가지(위, 왼, 위왼) 경우중 가장 많은 사탕을 가진 것에 그 위치의 캔디갯수를 더한 방식으로 구함
// 정답이긴 하지만 메모리와 시간을 너무 많이 잡아먹음
// 제출 결과 : [메모리: 78148KB 시간: 460ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] candy = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                // 굳이 안해줘도 되지만 연산 시간이 너무 걸려 특정 값은 연산을 안하게 함
                if(i==1 && j==1)
                    dp[i][j] = candy[1][1];
                else if(i==1)
                    dp[i][j] = dp[i][j-1]+candy[i][j];
                else if(j==1)
                    dp[i][j] += dp[i-1][j]+candy[i][j];
                else
                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+candy[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }
}

// dp에서는 왼과 오만 비교하면 되는 것을 깨닫게 됨
// 제출 결과:[메모리: 81664KB 시간: 428ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] candy = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+candy[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }
}
