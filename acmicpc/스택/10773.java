import java.util.Scanner;
import java.util.Stack;

public class Java_10773 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack s = new Stack();
        int count = scanner.nextInt();
        int check;
        int x , sum = 0;
        for(int i = 0; i<count; i++){
            check = scanner.nextInt();
            if(check == 0){
                x = Integer.parseInt(s.pop().toString());
                sum -= x;

            } else {
                s.push(check);
                sum += check;
            }
        }
        System.out.println(sum);
    }
}
