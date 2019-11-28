// 공통 부분 문자열

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
