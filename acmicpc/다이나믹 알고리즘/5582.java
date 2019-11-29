// 공통 부분 문자열

/*
*   이런 형식의 이전의 많은 문제를 풀어서 그대로 풀었다. 두 문자열 중 하나의 문자열을 기준으로 문자 하나를 추가하면서,
*   같다면 이전 값에서 문자 하나를 추가해주는 방식으로 풀었다.
*/

// 제출 결과 [메모리: 75996KB 시간: 192ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input1 = br.readLine();
        String Input2 = br.readLine();
        int dp[][] = new int[Input1.length()+1][Input2.length()+1];
        int max=0;

        for (int i = 1; i <= Input1.length(); i++) {
            for (int j = 1; j <= Input2.length(); j++) {
                if(Input1.charAt(i-1) == Input2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
