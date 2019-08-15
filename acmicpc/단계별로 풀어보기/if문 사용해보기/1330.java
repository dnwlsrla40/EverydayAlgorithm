//두 수 비교하기

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Java_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        System.out.println(A == B ? "==" : A > B ? ">" : "<");
    }

}
