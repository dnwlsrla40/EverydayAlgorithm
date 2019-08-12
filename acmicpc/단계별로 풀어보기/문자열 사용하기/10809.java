// 알파벳 찾기

// 처음 제출 [메모리 : 12924KB 시간 : 80ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10809 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(int i=97; i<123; i++){
            boolean flag = true;
            for(int j=0; j<input.length(); j++){
                if(i==(int)input.charAt(j)){
                    System.out.print(j + " ");
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.print("-1" + " ");
        }
    }
}

// indexOf 이용 방법
// 두번 째 제출 [메모리 : 12920KB 시간 : 72ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10809 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(char c = 'a'; c<='z'; c++){
            System.out.print(input.indexOf(c)+" ");
        }
    }
}

// 배열과 'a'만큼 빼는 것을 이용한 방법
// 세번 째 제출  [메모리 : 12912KB 시간 : 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int result[] = new int[26];
        for (int i=0; i<26; i++) {
            result[i] = -1;
        }

        for (int i=0; i<input.length; i++) {
            int check = input[i] - 97;

            if (result[check] == -1) {
                result[check] = i;
            }
        }

        for (int i=0; i<26; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
