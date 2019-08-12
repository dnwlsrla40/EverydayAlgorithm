// 문자열 반복

// 처음 제출 [메모리 : 12968KB 시간 : 80ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Java_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase>0){
            String[] testInput = br.readLine().split(" ");
            int repeat = Integer.parseInt(testInput[0]);
            String input = testInput[1];
            for(int i=0; i<input.length(); i++){
                for(int j=0; j<repeat; j++){
                    System.out.print(input.charAt(i));
                }
            }
            System.out.println();
            testCase--;
        }
    }
}
