// 효율적인 해킹

/*
*   시간 초과가 너무 많이 나와 처음으로 StringBuilder를 사용하였다.
*/

// 제출 결과: [메모리: 159076KB 시간: 9636ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Java_1325 {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] count;
    static int ans=0;
    static int n,m,cum1,cum2;

    public static void dfs(int cum){
        visit[cum] = true;
        for (int bcum : list[cum]){
            if(!visit[bcum]){
                count[bcum]++;
                dfs(bcum);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] Input = br.readLine().split(" ");

        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);

        list = new ArrayList[n+1];
        count = new int[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            Input = br.readLine().split(" ");
            int c1 = Integer.parseInt(Input[0]);
            int c2 = Integer.parseInt(Input[1]);
            list[c1].add(c2);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            dfs(i);
        }

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans,count[i]);
        }

        for (int i = 1; i <= n ; i++) {
            if(ans == count[i])
                sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }
}
