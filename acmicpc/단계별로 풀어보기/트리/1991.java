// 트리 순회

// 처음 제출[메모리: 12768KB 시간: 68ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1991 {

    static Node tree[];

    static public class Node {
        char data;
        Node left, right;

        public Node(char data){
            this.data = data;
        }
    }


    public static void preorder(int node) {
        System.out.print(tree[node].data);
        if(tree[node].left != null)
            preorder(tree[node].left.data - 'A');
        if(tree[node].right != null)
            preorder(tree[node].right.data - 'A');
    }

    public static void inorder(int node) {
        if(tree[node].left != null)
            inorder(tree[node].left.data - 'A');
        System.out.print(tree[node].data);
        if(tree[node].right != null)
            inorder(tree[node].right.data - 'A');
    }

    public static void postorder(int node) {
        if(tree[node].left != null)
            postorder(tree[node].left.data - 'A');
        if(tree[node].right != null)
            postorder(tree[node].right.data - 'A');
        System.out.print(tree[node].data);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for(int i=0; i<N; i++)
            tree[i] = new Node((char)('A'+i));

        for(int i=0; i<N; i++){
            String[] Input = br.readLine().split(" ");
            char root = Input[0].charAt(0);
            char left = Input[1].charAt(0);
            char right = Input[2].charAt(0);
            if(left != '.')
                tree[root-'A'].left = tree[left-'A'];
            if(right != '.')
                tree[root-'A'].right = tree[right-'A'];
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
}
