// 2차원 배열의 합

// Matrix 2차원 배열을 생성해 값을 입력하고 dp 2차원 배열을 생성해 해당 위치의 값이 이전 dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + 해당 위치의 값인 것을 이용해 풀었다.
// 제출 결과[메모리: 34444KB 시간: 432ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int Matrix[][] = new int[n+1][m+1];
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=m; j++){
                int input = Integer.parseInt(st.nextToken());
                Matrix[i][j] = input;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1) {
                    if(j==1)
                        dp[i][j] = Matrix[1][1];
                    else
                        dp[i][j] = dp[i][j - 1] + Matrix[i][j];
                } else if(j==1){
                    dp[i][j] = dp[i-1][j]+Matrix[i][j];
                }else{
                    dp[i][j] =dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+Matrix[i][j];
                }
            }
        }

        int k = Integer.parseInt(br.readLine());

        while(k-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(dp[x][y]-dp[i-1][y]-dp[x][j-1]+dp[i-1][j-1]);
        }
    }
}
