// 상수
// 입력을 받아 뒤집어 비교하는 방식도 있지만 BufferedReader의 입력값을 변환하는 방법을 연습하고 싶어 아래와 같이 구현

// 처음 제출[메모리 : 12884KB 시간 : 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        String A = Input[0];
        String B = Input[1];
        for(int i=2; i>=0; i--){
            if(A.charAt(i)>B.charAt(i)) {
                System.out.println(new StringBuffer(A).reverse().toString());
                break;
            }
            else if(A.charAt(i)<B.charAt(i)){
                System.out.println(new StringBuffer(B).reverse().toString());
                break;
            }
        }
    }
}
