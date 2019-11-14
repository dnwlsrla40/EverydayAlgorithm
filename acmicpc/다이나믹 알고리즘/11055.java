// 가장 큰 증가 부분 수열

/*
*   기존의 수열 문제들과 비슷하다.
*   arr과 dp에 기존 입력 값을 담고 다음 값이 이전 값보다 큰지 우선 비교하고 크다면 합의 값이 이전보다 큰지 확인해주면서 최대값을 찾는다.
*/

// 제출 결과[메모리: 13488KB 시간: 96ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int max = 0;
        String[] Input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(Input[i]);
            dp[i] = Integer.parseInt(Input[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
            }
            if(max<dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}
