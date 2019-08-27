// 나머지

// 처음 제출[메모리:12908KB 시간:80ms]
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Java_3052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List list = new ArrayList();
        int count=0;
        for(int i=0; i<10; i++){
            int input = Integer.parseInt(br.readLine())%42;
            if(!list.contains(input)) {
                list.add(input);
                count++;
            }
        }
        System.out.println(count);
    }
}
