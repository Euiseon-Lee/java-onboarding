package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] parts = cryptogram.split("");
        Stack<String> target = new Stack<>();
        for (String part : parts) {
            target.push(part);
        }

        while (!decryptingCheck(target)) {
            target = decrypting(target);
        }

        StringBuilder answer = new StringBuilder();
        while(!target.empty()) {
            answer.insert(0, target.pop());
        }

        return answer.toString();
    }
    
    
    public static Stack<String> decrypting (Stack<String> target){
        Stack<String> decryptingTarget = new Stack<>();
        decryptingTarget.push(target.firstElement());

        String compare = decryptingTarget.peek();
        for(int i=1; i<target.size(); i++) {
            if(compare.equals(target.elementAt(i))) {
                decryptingTarget.pop();
                compare = target.elementAt(i-1);
            }
            if(!compare.equals(target.elementAt(i))) {
                decryptingTarget.push(target.elementAt(i));
                compare = target.elementAt(i);
            }
        }
        return decryptingTarget;
    }
    

    public static boolean decryptingCheck (Stack<String> target){
        boolean check = true;
        for(int i=1; i<target.size(); i++) {
            if(target.get(i-1).equals(target.get(i))) {
                check = false;
                break;
            }
        }
        return check;
    }
}
