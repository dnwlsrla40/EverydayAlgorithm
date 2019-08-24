// 트리의 지름

//처음 제출[메모리: 23708KB 시간: 192ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Java_1967 {

    static boolean[] visit;
    static List<Vertex> list[];

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
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<Vertex>();
        }
        for(int i=0; i<N-1; i++) {
            String[] Input = br.readLine().split(" ");
            int parent= Integer.parseInt(Input[0]);
            int child = Integer.parseInt(Input[1]);
            int weight = Integer.parseInt(Input[2]);
            list[parent].add(new Vertex(child,weight));
            list[child].add(new Vertex(parent,weight));
        }
        Vertex first = dfs(1,0);
        visit = new boolean[N+1];
        Vertex back = dfs(first.vertex, 0);
        System.out.println(back.weight);
    }
}
