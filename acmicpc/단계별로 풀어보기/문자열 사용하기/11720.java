// 숫자의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] Input = br.readLine().split("");
        int sum=0;
        for(int i = 0; i < N; i++) {
            sum += Integer.parseInt(Input[i]);
        }
        System.out.println(sum);
    }
}
