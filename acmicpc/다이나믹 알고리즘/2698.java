// 인접한 비트의 개수
// 첫 접근은 문제에서 주어진 점화식을 사용하여 dp의 bottom-up 방법을 이용한 브루트 포스 방식으로 접근하려다 메모리 부하와 연산 수 때문에 포기
// 0부터 4까지 직접 수행
// 결국 k의 갯수는 이전 인덱스의 수(0 or 1)이 중요하단 것을 깨달음
// 주어진 n과 k를 이용하여 점화식을 알아보려 했지만 어려워 검색 후 3차원 배열을 이용하면 된다는 것을 깨닫고 참고

// 점화식 적용 후 다음 인덱스가 1이 올 때 k가 0인 경우에서 k-1 연산 시 인덱스 에러가 발생
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2698 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            int[][][] dp = new int[101][100][2];
            dp[1][0][0] = dp[1][0][1] = 1;
            for(int n=2; n<100; n++){
                for(int k=0; k<100; j++){
                    dp[n][k][1] += dp[n-1][k][0] + dp[n-1][k-1][1];
                    dp[n][k][0] += dp[n-1][k][0] + dp[n-1][k][1];
                }
            }
            while(T>0){
                String[] Input = br.readLine().split(" ");
                int n = Integer.parseInt(Input[0]); // 비트의 수
                int k = Integer.parseInt(Input[1]); // 인접한 비트 수
                System.out.println(dp[n][k][0]+dp[n][k][1]);
                T--;
            }
        }
}

// 처음 제출[메모리: 13224KB 시간: 80ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2698 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            int[][][] dp = new int[101][100][2];
            dp[1][0][0] = dp[1][0][1] = 1;
            for(int n=2; n<=100; n++){
                for(int k=0; k<100; k++){
                    if(k==0)
                        dp[n][k][1] += dp[n-1][k][0];
                    else
                        dp[n][k][1] += dp[n-1][k][0] + dp[n-1][k-1][1];
                    dp[n][k][0] += dp[n-1][k][0] + dp[n-1][k][1];
                }
            }
            while(T>0){
                String[] Input = br.readLine().split(" ");
                int n = Integer.parseInt(Input[0]); // 비트의 수
                int k = Integer.parseInt(Input[1]); // 인접한 비트 수
                System.out.println(dp[n][k][0]+dp[n][k][1]);
                T--;
            }
        }
}

