// 설탕 배달

// 처음 제출 [메모리 : 12904 KB 시간 : 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2837 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=Input/5; i>0; i-- ){
            if((Input-(5*i))%3==0){
                count += i;
                Input -= 5*i;
                break;
            }
        }
        if(Input%3==0) {
            count += (Input / 3);
            Input -= (Input / 3) * 3;
        }
        if(Input != 0)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}
