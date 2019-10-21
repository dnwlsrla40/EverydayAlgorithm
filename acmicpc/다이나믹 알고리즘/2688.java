// 줄어들지 않아

// dp n자리에 따라서 올 수있는 숫자가 나뉘므로 이차원 배열로 생각
// dp n자리에서 뒤가 i일 때 올수 있는 경우의 수는 n-1(한자리 작은 수)에서의 자리 수가 i보다 작거나 같아야한다.
// 계속 틀렸다고 나와서 고민하다가 찾아보니 long 자료형을 써야한다고 깨달았다. 자료형에 대해 자주 틀리는 것 같다.
// 제출 결과: [메모리: 13432KB 시간: 84ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        while(Tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            long[][] dp = new long[65][10];
            long sum = 0;
            for (int i = 0; i < 10; i++)
                dp[1][i] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <10 ; j++) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
            for(int i =0; i<10; i++)
                sum += dp[n][i];
            System.out.println(sum);
        }
    }
}
