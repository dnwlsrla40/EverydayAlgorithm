// 보물섬

/*
*   처음엔 문제가 이해가 잘 안되었지만, 이해하고 나니 쉬운 문제였다. 생각보다 시간이 너무 길게 나와 좀 더 고민해봐야겠다.
*/

// 제출 결과: [메모리:142840KB 시간: 464ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Java_2589 {
    static Queue<Node> q = new LinkedList<>();
    static String[][] map;
    static boolean[][] visit;
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n, m;
    static int ans=0;

    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Node temp = q.poll();
                int x = temp.x;
                int y = temp.y;
                ans = Math.max(ans, temp.count);
                for (int i = 0; i < 4; i++) {
                    int dx = x + check[i][0];
                    int dy = y + check[i][1];
                    if(0<=dx && 0<=dy && dx<n && dy<m){
                        if(!visit[dx][dy] && map[dx][dy].equals("L")){
                            visit[dx][dy] = true;
                            q.add(new Node(dx,dy,temp.count+1));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);

        map = new String[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            Input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Input[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j].equals("L")) {
                    visit[i][j] = true;
                    q.add(new Node(i,j,0));
                    bfs();
                    for (int k = 0; k < n; k++) {
                        Arrays.fill(visit[k], false);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
