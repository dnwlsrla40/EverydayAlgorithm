// 최소, 최대

// 처음 제출[메모리: 136724KB 시간: 580ms]
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Java_10818 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] Input = br.readLine().split(" ");
        int min = Integer.parseInt(Input[0]);
        int max = Integer.parseInt(Input[0]);
        for(int i=0; i<N; i++){
            if(Integer.parseInt(Input[i])>max)
                max=Integer.parseInt(Input[i]);
            if(Integer.parseInt(Input[i])<min)
                min=Integer.parseInt(Input[i]);
        }
        System.out.println(min + " " + max);
    }
}
