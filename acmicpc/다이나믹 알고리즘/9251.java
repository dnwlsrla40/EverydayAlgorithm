// LCS

/*
*  처음에는 두 개의 문자열 중 하나를 잡고 일일이 비교해보면서 진행하는 방법을 생각 했지만, dp문제와 어울리지 않는 하여 다르게 접근해보기로 하였다.
*  LCS에서 문자열 X와 Y의 마지막 문자가 같을 때, 그 전 LCS에 마지막 문자가 추가되어 +1이 될 것이다.
*  그리고, 마지막 문자가 다를 경우, X에서 Y를 비교 한 것과 Y에서 X를 비교 한 것 중 더 큰 값이 현재의 LCS 값일 것이다.
*/

// 제출 결과:[메모리: 17384KB 시간: 124ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input1 = br.readLine().split("");
        String[] Input2 = br.readLine().split("");
        int[][] dp = new int[Input1.length+1][Input2.length+1];

        for (int i = 1; i <= Input1.length; i++) {
            for (int j = 1; j <= Input2.length; j++) {
                if(Input1[i-1].equals(Input2[j-1]))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[Input1.length][Input2.length]);
    }
}
