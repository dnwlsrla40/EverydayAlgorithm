import java.util.Scanner;
import java.util.Stack;


// acmicpc 에서 내부 클래스 사용을 막아놓은 건지 책처럼 IntStack을 사용하니 런타임 에러 발생
// 그래서 java.util.Stack 사용

public class Java_10828 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack s = new Stack();
        int count = scanner.nextInt();
        String Ins;
        int x;
        for(int i = 0; i<count; i++){
            Ins = scanner.next();
            switch (Ins){
                case "push":
                    x = scanner.nextInt();
                    s.push(x);
                    break;

                case "pop":
                    if(s.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(s.pop());
                    break;

                case "size":
                    x = s.size();
                    System.out.println(x);
                    break;

                case "empty":
                    if(s.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "top":
                    if(s.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(s.peek());
                    break;
            }
        }
    }
}
