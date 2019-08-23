// 트리의 지름
// 해결 팁 : 하나의 정점에서 가장 멀리 있는 정점은 원의 지름 부분에 해당하는 정점이다.

// 처음 제출 [메모리 : 86712KB 시간 : 668ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Java_11725 {

    static boolean[] visit;
    static List<Vertex>[] list;

    static public class Vertex{
        public int vertex;
        public int weight;

        public Vertex(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static public Vertex dfs(int v, int sum){
        visit[v] = true;
        Vertex max = new Vertex(v, sum);
        for(Vertex el : list[v]){
            if(!visit[el.vertex]){
                Vertex temp = dfs(el.vertex, sum+el.weight);
                if(max.weight<temp.weight)
                    max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v_num = Integer.parseInt(st.nextToken());
            list[v_num] = new ArrayList<Vertex>();
            while(st.hasMoreTokens()){
                int v= Integer.parseInt(st.nextToken());
                if(v==-1)
                    break;
                int w = Integer.parseInt(st.nextToken());
                list[v_num].add(new Vertex(v, w));
            }
        }
        Vertex first = dfs(1,0);
        visit = new boolean[N+1];
        Vertex back = dfs(first.vertex, 0);
        System.out.println(back.weight);
    }
}
