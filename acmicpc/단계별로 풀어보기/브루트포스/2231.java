import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2231 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean flag=false;
        for(int i=1; i<N; i++){
            if(N == Constructor(i)){
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println(0);
    }

    static public int Constructor(int N){
        int temp = N;
        while(N>0){
            temp += (N%10);
            N/=10;
        }
        return temp;
    }
}
