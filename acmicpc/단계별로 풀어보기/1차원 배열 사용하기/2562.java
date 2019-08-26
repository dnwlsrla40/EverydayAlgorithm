// 최댓값

// 처음 제출[메모리: 12880KB 시간: 76ms]
// 배열 사용 X 방법
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Java_2562 {
     public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int index=1, max=0;
         for(int i=1; i<=9; i++){
             int num = Integer.parseInt(br.readLine());
             if(num>max) {
                 max = num;
                 index = i;
             }
         }
         System.out.println(max);
         System.out.println(index);
     }
}
