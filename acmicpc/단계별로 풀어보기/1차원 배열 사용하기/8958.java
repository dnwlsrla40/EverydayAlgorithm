//OX 퀴즈

// 처음 제출 [메모리 : 13752KB 시간 : 104ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        for(int i=0; i<TestCase; i++){
            int count=1;
            int sum=0;
            String[] Input = br.readLine().split("");
            for(int j=0 ; j < Input.length; j++){
                if(Input[j].equals("O")){
                    sum+=count;
                    count++;
                } else
                    count = 1;
            }
            System.out.println(sum);
        }
    }
}
