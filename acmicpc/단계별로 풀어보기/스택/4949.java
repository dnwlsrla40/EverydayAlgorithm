import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Java_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String string = br.readLine();
            if(string.equals("."))
                break;
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i=0; i<string.length(); i++){
                char check = string.charAt(i);
                if(check == '(' || check == '[')
                    stack.push(check);
                else if(check == ')') {
                    if (stack.isEmpty() || !stack.pop().toString().equals("("))
                        flag = false;
                }
                else if(check == ']'){
                    if (stack.isEmpty() || !stack.pop().toString().equals("["))
                        flag = false;
                }
            }
            if(flag && stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
