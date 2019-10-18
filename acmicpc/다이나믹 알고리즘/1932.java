// 정수 삼각형

// 기존 틀은 다른 행렬의 최대값을 구하는 방법을 사용했다. dp[i][j] = 될 수 있는 이전 값 중 큰값 + 자기자신의 값
// 하지만, 한가지 커다란 실수를 한 것이 입력 값이 삼각형 모양이라 나는
// 7 8 0 4 5
// 3 1 4 6
// 8 7 2
// 2 5
// 4
// 인 형태의 행렬을 생각하여 코드를 구상하여 입력 값을 행렬에 넣는 방식에서 많이 힘들었다.
// 후에 다른 코드를 보니, 입력값 받은 순서대로
// 7
// 3 8
// 8 1 0
// 2 7 4 4
// 4 5 2 6 5
// 인 행렬을 만들어 dp처리를 해주었으면 된다.
// 제출 결과: [메모리: 26144KB 시간: 240ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        int max = 0;

        int a=2,b=1;
        map[1][1] = Integer.parseInt(br.readLine());
        for(int k=1; k<n; k++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                if(a==1) {
                    map[a][b] = Integer.parseInt(st.nextToken());
                    a = b + 1;
                    b = 1;
                } else{
                    map[a][b] = Integer.parseInt(st.nextToken());
                    a--;
                    b++;
                }
            }
        }

        for (int i=1; i <=n+1; i++) {
            for (int j=1; j <= n-i+1; j++) {
                dp[i][j] += Math.max(dp[i-1][j],dp[i][j-1])+map[i][j];
            }
        }

        for (int i=1; i<=n; i++) {
                if(max<dp[i][n+1-i])
                    max = dp[i][n+1-i];
        }
        System.out.println(max);
    }
}

// 입력값 받은 순서대로의 코드
// 위 보다 메모리가 많이 든 이유가??
// 제출 결과: [메모리: 27916KB 시간: 236ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        int max = 0;

        for (int i = 1; i < n+1; i++) {
            String[] Input = br.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(Input[j-1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(j==1)
                    dp[i][j] += dp[i-1][j];
                else if(i==j)
                    dp[i][j] += dp[i-1][j-1];
                else
                    dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
                if(max<dp[i][j])
                    max = dp[i][j];
            }
        }

        System.out.println(max);
    }
}

// 이해 안가는 코드
public static void main(String[] args) {
    InputReader in = new InputReader(System.in);

    n = in.nextInt();
    a = new int[n + 1][n + 1];
    d = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        a[i][j] = in.nextInt();
      }
    }

    d[1][1] = a[1][1];
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= i; j++) {
        d[i + 1][j] = Math.max(d[i + 1][j], d[i][j] + a[i + 1][j]);
        d[i + 1][j + 1] = Math.max(d[i + 1][j + 1], d[i][j] + a[i + 1][j + 1]);
      }
    }

    int ret = 0;
    for (int j = 1; j <= n; j++) {
      ret = Math.max(ret, d[n][j]);
    }

    System.out.println(ret);
  }