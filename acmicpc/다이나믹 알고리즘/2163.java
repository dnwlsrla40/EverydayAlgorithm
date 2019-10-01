// 초콜릿 자르기

// N=2, M=2인 Case, N=2, M=3인 Case, N=3, M=3인 Case로 N*M-1 인 점화식 발견
// 후에 인터넷 참고해보니 N*M인 경우 (M-1)+(N-1)M)=M-1+MN-M=MN-1이 자르는 횟수 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        int N = Integer.parseInt(Input[0]);
        int M = Integer.parseInt(Input[1]);
        System.out.println(N*M-1);
    }
}


// 제출 결과 [메모리 : 12948KB 시간 : 84ms]
// 재귀 함수를 사용해서 분할 정복적인 방법으로 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2163 {

    static int count = 0;

    public static void cut(int n, int m){
        if(n!=1 || m !=1){
            count++;
            if(n!=1){
                cut(1, m);
                cut(n-1, m);
            }
            else if(m!=1){
                cut(n, 1);
                cut(n, m-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        int N = Integer.parseInt(Input[0]);
        int M = Integer.parseInt(Input[1]);
        cut(N, M);
        System.out.println(count);
    }
}
