// A+B - 5

// 처음 제출[메모리 : 13008KB 시간 : 84ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10952 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] Input = br.readLine().split(" ");
            int a = Integer.parseInt(Input[0]);
            int b = Integer.parseInt(Input[1]);
            if(a==0 && b==0)
                break;
            System.out.println(a+b);
        }
    }
}
