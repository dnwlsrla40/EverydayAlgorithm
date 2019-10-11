// 1,2,3 더하기
// 5,6,7 까지 수기로 진행하면서 특정 부분이 패턴을 이루는 지 확인하였다.
// 패턴이 있긴 했지만 코드로 어떻게 짤지 고민하다 이전 꺼 3개의 합이 다음의 결과가 된다는 것을 이용해서 풀었다.

// 제출 결과 : [메모리: 12880KB 시간: 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        int dp[] = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<11; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        while(Tc>0){
            Tc--;
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
