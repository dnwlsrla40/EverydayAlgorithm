// 가장 긴 바이토닉 부분 수열

// 전에 풀어본 문제와 비슷하게 수열을 찾고 반대로 뒤쪽에서도 가장 긴 수열을 찾아서 둘의 길이를 더한다.
// 최대 값이 중복되므로 -1을 해준다.
// 제출 결과 [메모리: 13768KB 시간: 120ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int[] rdp = new int[n+1];
        String[] Input = br.readLine().split(" ");
        int max = 0;
        for (int i = 1; i <=n ; i++) {
            arr[i] = Integer.parseInt(Input[i-1]);
        }

        for (int i = 1; i <=n ; i++) {
            dp[i]=1;
            for(int j=1; j<=i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for (int i = n; i >= 1 ; i--) {
            rdp[i]=1;
            for(int j = n; j >= i; j--){
                if(arr[i]>arr[j]){
                    rdp[i] = Math.max(rdp[i], rdp[j]+1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i] + rdp[i]);
        }

        System.out.println(max-1);
    }
}
