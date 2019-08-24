// A+B-3

// 처음 제출[메모리: 12940KB 시간: 80ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] Input = br.readLine().split(" ");
            int A = Integer.parseInt(Input[0]);
            int B = Integer.parseInt(Input[1]);
            System.out.println(A+B);
        }
    }
}

// 두 번째 제출[메모리: 12864KB 시간: 76ms] 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] Input = br.readLine().split(" ");
            System.out.println(Integer.parseInt(Input[0])+Integer.parseInt(Input[1]));
        }
    }
}