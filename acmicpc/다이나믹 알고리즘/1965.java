// 상자 넣기

/*
*   dp는 각 수까지 증가하는 최대 수의 갯수이다. 여기서는 자기자신의 상자 수도 포함하므로, 자기자신보다 작은 수가 없는 초기값은 1이된다.
*   그 뒤로는 이전 값이 지금 비교하는 값보다 작고, 가지고 있는 상자 수가 젤 큰것을 찾아서 +1 해줄 것을 dp 값으로 설정해주면 된다.
*/

// 제출 결과[메모리: 13396KB 시간: 104ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bag = new int[n+1];
        int[] dp = new int[n+1];
        int max = 0;
        String[] Input = br.readLine().split(" ");

        for (int i = 1; i <= n ; i++) 
           bag[i] = Integer.parseInt(Input[i-1]);

        for (int i = 1; i <= n; i++) {
            dp[i]=1;
            for (int j = 1; j < i; j++) {
                if(bag[j]<bag[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j]+1;
            }
            if(max<dp[i]) max=dp[i];
        }
        System.out.println(max);
    }
}
