// 신나는 함수 실행

/*
*   메모제이션을 사용할 수 있는 문제인 것 같다. 두 번째 조건 20이 넘으면 20으로 출력하는 것을 이용해서 dp 크기를 21로 잡고,
*   0 이하는 1로 세팅 되고 기존에 저장된 값이 있다면, 그것을 리턴해서 재귀 호출 시간을 줄였다.
*   출력 형태를 값만 출력해서 틀렸었다.
*/

// 제출 결과: [메모리: 14464KB, 시간: 92ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_9184 {

    static int[][][] dp = new int[21][21][21];

    static boolean check(int a, int b, int c){
        if((0<=a && a<=20) && (0<=b && b<=20) && (0<=c && c<=20))
            return true;
        else
            return false;
    }

    static int w(int a, int b, int c){
        if(check(a,b,c) && dp[a][b][c] != 0)
            return dp[a][b][c];
        if(a<=0 || b<=0 || c<=0)
            return 1;
        else if(a>20 || b>20 || c>20)
            return dp[20][20][20] = w(20,20,20);
        else if(a<b && b<c)
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        else
            return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    dp[i][j][k] = w(i,j,k);
                }
            }
        }
        while(true) {
            String[] Input = br.readLine().split(" ");
            int a = Integer.parseInt(Input[0]);
            int b = Integer.parseInt(Input[1]);
            int c = Integer.parseInt(Input[2]);
            if (a == -1 && b == -1 && c == -1)
                break;
            else{
                System.out.println("w("+a+", "+b+", "+c+")"+" = "+w(a,b,c));
            }
        }
    }
}
