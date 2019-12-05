// 로또

// 제출 결과: [메모리: 17828KB 시간: 172ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_6603 {
    static int[] map;
    static int[] ans = new int[6];
    static int k;

    public static void dfs(int start, int count){
        if(start>=map.length && count < 6)
            return;
        if(count == 6){
            for (int i = 0; i < 6; i++)
                System.out.print(ans[i]+" ");
            System.out.println();
        }else {
            ans[count] = map[start];
            dfs(start+1, count+1);
            ans[count] = 0;
            dfs(start+1, count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] Input = br.readLine().split(" ");
            k = Integer.parseInt(Input[0]);
            map = new int[k];

            if(k == 0)
                break;

            for (int i = 0; i < k; i++) {
                map[i] = Integer.parseInt(Input[i+1]);
            }
            dfs(0,0);
            System.out.println();
        }
    }
}
