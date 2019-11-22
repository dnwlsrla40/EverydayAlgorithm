// 팰린드롬 분할

/*
*   문제가 너무 어려워 우선 팰린드롬 알고리즘이 있는 지 검색하여서 풀어보았지만, 반복문 때문에 시간이 오래걸려 해결이 안되어 블로그를 참고하였다.
*   큰 틀은 팰린드롬이 되는 부분(j~i사이의 값들이 대칭이어야 한다.)을 체크를 해주고 dp[i]는 각 자리수에 최소의 팰린드롬 수이다.
*/

// 제출 결과: [메모리: 20228KB 시간: 220ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1509 {

    static boolean[][] isPalindrome;

    static void Palindrome(String[] Input){
        isPalindrome = new boolean[Input.length+1][Input.length+1];

        // 한자리수 초기화
        for (int i = 1; i <= Input.length; i++) {
            isPalindrome[i][i] = true;
        }

        // 두자리수 초기화
        for (int i = 1; i < Input.length; i++) {
            if(Input[i-1].equals(Input[i]))
                isPalindrome[i][i+1] = isPalindrome[i+1][i] = true;
        }

        //3자리수 이상
        for (int i = 2; i < Input.length; i++) {
            for (int j = 1; j <= Input.length-i; j++) {
                if(Input[j-1].equals(Input[j+i-1]) && isPalindrome[j+1][j+i-1])
                    isPalindrome[j][j+i] = isPalindrome[j+i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split("");
        int[] dp = new int[Input.length+1];
        Palindrome(Input);
        for (int i = 1; i <= Input.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if(isPalindrome[j][i])
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
            }
        }
        System.out.println(dp[Input.length]);
    }
}
