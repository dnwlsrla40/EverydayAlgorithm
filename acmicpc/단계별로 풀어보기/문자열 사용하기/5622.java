// 다이얼
// 각 번호를 누를 때 걸리는 시간은 누른 번호 +1
// switch를 사용하여 입력 값의 문자가 무엇이냐에 따라 second 증가

// 처음 제출 [메모리 : 12884KB 시간 : 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = br.readLine();
        int second = 0;
        for(int i=0; i<Input.length(); i++){
            switch (Input.charAt(i)){
                case 'A':
                case 'B':
                case 'C':
                    second += 3;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    second += 4;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    second += 5;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    second += 6;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    second += 7;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    second += 8;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    second += 9;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    second +=10;
                    break;
            }
        }
        System.out.println(second);
    }
}
