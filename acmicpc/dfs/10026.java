import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] map, b_map;
    static boolean[][] visit, b_visit;
    static int[][] check = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int n;
    static int count=0;
    static int b_count=0;

    public static void dfs(int x, int y, String color){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];
                if(0<=dx && 0<=dy && dx<n && dy<n){
                    if(!visit[dx][dy] && map[dx][dy].equals(color)) {
                        visit[dx][dy] = true;
                        dfs(dx, dy, color);
                    }
                }
            }
        }
    }

    public static void b_dfs(int x, int y, String color){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];
                if(0<=dx && 0<=dy && dx<n && dy<n){
                    if(!b_visit[dx][dy] && b_map[dx][dy].equals(color)) {
                        b_visit[dx][dy] = true;
                        b_dfs(dx, dy, color);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        b_map = new String[n][n];
        visit = new boolean[n][n];
        b_visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] Input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Input[j];
                if(Input[j].equals("G"))
                    b_map[i][j] = "R";
                else
                    b_map[i][j] = Input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!b_visit[i][j] && (b_map[i][j].equals("R") || b_map[i][j].equals("B"))){
                    b_count++;
                    b_visit[i][j] = true;
                    b_dfs(i,j,b_map[i][j]);
                }
                if(!visit[i][j] && (map[i][j].equals("R") || map[i][j].equals("B") || map[i][j].equals("G"))) {
                    count++;
                    visit[i][j] = true;
                    dfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(count + " " + b_count);
    }
}
