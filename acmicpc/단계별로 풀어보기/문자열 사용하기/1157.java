// 단어 공부

// 처음 제출 [메모리 : 27820KB 시간 : 216ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] Input = br.readLine().toLowerCase().toCharArray();
        int[] alpabet = new int[26];
        int max = 0;
        char result = '?';
        for(int i=0; i<26; i++){
            alpabet[i] = 0;
        }

        for(int i=0; i<Input.length; i++){
            int check = Input[i] -97;
            alpabet[check]++;
        }

        for(int i=0; i<26; i++){
            if(max < alpabet[i]) {
                max = alpabet[i];
                result = (char) (i+65);
            } else if(max==alpabet[i] && max != 0)
                result = '?';
        }
        System.out.println(result);
    }
}
