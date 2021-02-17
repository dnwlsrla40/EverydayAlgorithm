import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int m,n,h,count=0;
    static int[][][] map;
    static boolean[][][] visit;
    static int[][][] dist;
    static int[][] check = {{0,0,1},{0,0,-1},{-1,0,0},{1,0,0},{0,1,0},{0,-1,0}};
    static Queue<Node> q = new LinkedList<>();

    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int z = temp.z;

            for (int i = 0; i < 6; i++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];
                int dz = z + check[i][2];
                if(0<=dx && 0<=dy && 0<=dz && dx<n && dy<m && dz<h){
                    if(!visit[dx][dy][dz] && map[dx][dy][dz] == 0){
                        map[dx][dy][dz] = 1;
                        visit[dx][dy][dz] = true;
                        dist[dx][dy][dz] = dist[x][y][z]+1;
                        q.add(new Node(dx,dy,dz));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        m = Integer.parseInt(Input[0]);
        n = Integer.parseInt(Input[1]);
        h = Integer.parseInt(Input[2]);

        map = new int[n][m][h];
        visit = new boolean[n][m][h];
        dist = new int[n][m][h];
        boolean flag = false;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                Input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    map[j][k][i] = Integer.parseInt(Input[k]);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(map[j][k][i] == 1) {
                        visit[j][k][i] = true;
                        q.add(new Node(j,k,i));
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    count = Math.max(count, dist[j][k][i]);
                    if(map[j][k][i] == 0)
                        flag = true;
                }
            }
        }

        if(flag)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}
