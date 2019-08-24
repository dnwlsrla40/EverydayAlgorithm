// A+B - 8

// 처음 제출[메모리: 13568KB 시간: 84ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            String[] Input = br.readLine().split(" ");
            System.out.print("Case #"+i+": ");
            System.out.print(Integer.parseInt(Input[0])+" + "+Integer.parseInt(Input[1])+" = ");
            System.out.println(Integer.parseInt(Input[0])+Integer.parseInt(Input[1]));
        }
    }
}
