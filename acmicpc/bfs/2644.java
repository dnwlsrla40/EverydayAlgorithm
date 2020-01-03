// 촌수 계산

// 제출 결과: [메모리: 13016KB 시간: 72ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_2644 {
    static int n,m;
    static int[][] map;
    static boolean[] visit;
    static int[] dist;
    static int vill1, vill2;

    public static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp == end)
                break;

            for (int i = 1; i <= n; i++) {
                if(!visit[i] && map[temp][i] == 1){
                    visit[i] = true;
                    q.add(i);
                    dist[i] = dist[temp] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] Input = br.readLine().split(" ");
        vill1 = Integer.parseInt(Input[0]);
        vill2 = Integer.parseInt(Input[1]);
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        dist = new int[n+1];

        for (int i = 0; i < m; i++) {
            Input = br.readLine().split(" ");
            int v1 = Integer.parseInt(Input[0]);
            int v2 = Integer.parseInt(Input[1]);
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }

        bfs(vill1, vill2);

        if(dist[vill2] == 0)
            System.out.println(-1);
        else
            System.out.println(dist[vill2]);
    }
}
