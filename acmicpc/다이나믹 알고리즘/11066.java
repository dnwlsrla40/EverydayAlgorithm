// 파일 합치기

/* 
    처음엔 인접한 2개만 되는 지 모르고 최소 순으로 정렬해서 인접한 것끼리 합치려 했다.
    후에 틀렸다고 하기에 문제를 다시보고 깨달았다.
    dp를 잘게 쪼개서 최소의 합들을 합하면 최소일거라 생각
    arr : 파일의 입력의 합 (일일이 해주다가 처음부터 합해주는 것이 이득인 것을 알았다.)
    dp[i][j] :  i에서 j구간의 최소합
    i에서 j의 구간을 나누어 최소합을 계산한다.
*/
// 제출 결과:[메모리: 22572KB 시간: 344ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        while(Tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] Input = br.readLine().split(" ");
            int[] arr = new int[n+1];
            int[][] dp = new int[n+1][n+1];
            for (int i = 1; i <= n ; i++) {
                arr[i] = arr[i-1]+Integer.parseInt(Input[i-1]);
            }
            for (int i =1; i < n; i++) {
                for(int j=1; j<= n-i; j++) {
                    dp[j][j+i] = Integer.MAX_VALUE;
                    for(int k=j; k<j+i; k++) {
                        // 전의 dp 값들을 참조하면서 비교
                        dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k]+ dp[k+1][j+i]+arr[j+i] - arr[j-1]);
                    }
            }
            }
            System.out.println(dp[1][n]);
        }
    }
}

// 다른 맞은 사람 코드
/*
    위의 내가 맞은 코드는 모든 경우의 수를 다 해보는 것이다.
    이 코드는 각 인접한 챕터의 최소값을 합치면 최소가 된다는 것을 이용한 방법이다.
*/
// 제출 결과:[메모리 : 22012KB 시간 : 176ms]
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 11066 {

    static int[][] dp = new int[501][501];
    static int[] novel = new int[501];
    static int[] C = new int[501];  // 합치는 비용
    static int[][] A = new int[501][501];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        while(test_case-- > 0) {
            int chapter = Integer.parseInt(br.readLine()); // 챕터 수
            String[] c_size = br.readLine().split(" ");

            for(int i = 1; i <= chapter; i++) {
                novel[i] = Integer.parseInt(c_size[i-1]);
                C[i] = C[i-1] + novel[i];
            }

            /*
            i 기준으로 1,2,3,4 ... 챕터 수 만큼
            A는 합칠 수 있는 챕터가 서로 인접한 챕터끼리 가능하므로 인덱스의 기준이 된다.
             */
            for(int i = 1; i <= chapter; i++) {
                A[i-1][i] = i;
            }

            for(int i = 1; i <= chapter; i++) {
                System.out.println("A["+(i-1)+"]["+i+"] : "+A[i-1][i]);
            }

            for(int i = 2; i <= chapter; i++) {
                for(int x = 0; x + i <= chapter; x++) {
                    int y = x + i;
                    dp[x][y] = Integer.MAX_VALUE;
                    for(int k = A[x][y-1]; k <= A[x+1][y]; k++) {
                        System.out.println("x ; " + x + " y : "+ y + " A[x][y-1] : "+A[x][y-1] + " ~ A[x+1][y] : " + A[x+1][y] + " k : " + k);
                        // dp 값을 갱신
                        int min = dp[x][k] + dp[k][y] + C[y] - C[x];

                        // 갱신된 dp 값이 최소면 그 dp 값을 기억
                        if(dp[x][y] > min) {
                            dp[x][y] = min;
                            A[x][y] = k;
                        }
                    }
                }
            }
            sb.append(dp[0][chapter] + "\n");
        }
        System.out.print(sb);
    }
}
