import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_2164 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int count = scanner.nextInt();

        for(int i=1; i<=count; i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            queue.remove();
            if(queue.size() == 1)
                break;
            queue.add(queue.remove());
        }
        System.out.println(queue.poll().toString());
    }
}
