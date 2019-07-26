import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_10845 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = scanner.nextInt();
        String Ins;
        int x;
        int last_num = 0;
        for(int i = 0; i<count; i++){
            Ins = scanner.next();
            switch (Ins){
                case "push":
                    x = scanner.nextInt();
                    queue.add(x);
                    last_num = x;
                    break;

                case "pop":
                    if(queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.poll());
                    break;

                case "size":
                    x = queue.size();
                    System.out.println(x);
                    break;

                case "empty":
                    if(queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "front":
                    if(queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peek());
                    break;

                case "back":
                    if(queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(last_num);
                    break;
            }
        }
    }
}
