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
                        dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k]+ dp[k+1][j+i]+arr[j+i] - arr[j-1]);
                    }
            }
            }
            System.out.println(dp[1][n]);
        }
    }
}
