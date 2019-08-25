// A+B - 7

// 처음 제출[메모리: 12892KB 시간: 84ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            String[] Input = br.readLine().split(" ");
            System.out.println("Case #"+i+": "+(Integer.parseInt(Input[0])+Integer.parseInt(Input[1])));
        }
    }
}
