import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    
    public int minLengthBruteForce(String s){
        Boolean noneFound = false;
        while(s.length()>0 && !noneFound){
            int indx1 = s.indexOf("AB");
            int indx2 = s.indexOf("CD");
            if(indx1 != -1){
                s = s.substring(0,indx1)+s.substring((indx1+2));
            }
            else if(indx2 != -1){
                s = s.substring(0,indx2)+s.substring((indx2+2));
            }
            else{
                noneFound = true;
            }
        }
        return s.length();
    }

    public int minLengthOptimised(String s){

        Stack<Character> stack = new Stack<>();

        //the main formula here is the we are going to push 1 character in the stack and check the next character if we encounter a B or D we will check the top of the stack to find A or C, if found we will simply pop the top
        //lastly we will return the length of the stack

        stack.push(s.charAt(0));
        
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);

            if((ch == 'B' && stack.peek()=='A') || (ch == 'D' && stack.peek() == 'C')){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.size();
    }

    //main method
    public static void main(String[] args) {
        String str = "ABFCACDB";
        MinimumStringLengthAfterRemovingSubstrings obj = new MinimumStringLengthAfterRemovingSubstrings();
        System.out.println("The input string is is ::"+str);
        System.out.println("The value from bruteforce is ::"+obj.minLengthBruteForce(str));
        System.out.println("The input string is is ::"+str);
        System.out.println("The value from optimised is ::"+obj.minLengthOptimised(str));
    }
}
