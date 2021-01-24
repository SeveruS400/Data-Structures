package hafta2;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Islemler {
    public static <T> Stack<T> tersCevir(Stack<T> s){

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> copiedStack = (Stack<Integer>)s.clone();

        while(!copiedStack.empty()){
            stack.add(copiedStack.pop());
        }
        return (Stack<T>) stack;
    }

    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
        return s1.equals(s2);
    }


    public static int postfixDegerlendir(String girdi) {
        String[] tokens = splitToTokens(girdi);
        Stack<Integer> op = new Stack<>();
        int result = 0;

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                op.push(Integer.parseInt(token));
            }
            else {
                int operand_1 = op.pop();
                int operand_2 = op.pop();

                if (token.equals("+"))
                    result = operand_2 + operand_1;

                else if (token.equals("-"))
                    result = operand_2 - operand_1;

                else if (token.equals("*"))
                    result = operand_2 * operand_1;

                else if (token.equals("/"))
                    result = operand_2 / operand_1;

                op.push(result);
            }
        }

        return op.pop();
    }

    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    //boyut farkı var-------------------------------------------------------------------
        public static String infixToPostfix(String girdi){
            Stack<String> stack = new Stack<>();
            List<String> output = new ArrayList();


            String[] symbols = splitToTokens(girdi);
            for (String symbol : symbols) {
                if (Character.isDigit(symbol.charAt(0))) {
                    output.add(symbol);
                }

                else if (symbol.equals("(")) {
                    stack.push(symbol);
                }

                else if (symbol.equals(")")) {
                    while(true) {
                        if (! stack.peek().equals("("))
                            output.add(stack.pop());
                        else
                            break;
                    }
                }

                else {
                    int symbolPriority = Priority(symbol);

                    if (! stack.isEmpty()) {
                        int opstackPriority = Priority(stack.peek());

                        while (opstackPriority > symbolPriority) {
                            if (! stack.isEmpty()) {
                                opstackPriority = Priority(stack.peek());
                                output.add(stack.pop());
                            }
                            else
                                break;
                        }

                    }
                    stack.push(symbol);
                }
            }

            while (!stack.isEmpty()) {
                output.add(stack.pop());
            }

            String postfix = "" ;
            for (String token : output) {
                postfix += token + " ";
            }

            return postfix;
        }
    private static int Priority(String symbol) {
        int priority = 0;

        if (symbol.equals("+") || symbol.equals("-"))
            priority = 0;
        else if (symbol.equals("*") || symbol.equals("/"))
            priority = 1;
        else
            priority = -1;

        return priority;
    }

        private static String[] splitToTokens(String girdi)
        {
            StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
            List<String> tokenList=new ArrayList<>();
            while (t.hasMoreTokens()){
                String s=t.nextToken().trim();
                if(!s.equals(""))
                    tokenList.add(s);
            }
            String [] tl=new String[tokenList.size()];
            tokenList.toArray(tl);
            return tl;
        }
}
/*public static String infixToPostfix(String girdi){
        String n = null;
        String son = null;
        String[] tl= new String[girdi.length()];
        tl=splitToTokens(girdi);
        for(int i=0;i<girdi.length();i++){
            if(tl[i]=="+"|| tl[i]=="-"||tl[i]=="*"||tl[i]=="/"){
                n =tl[i];
            }
        }
        for(int j=0;j<girdi.length();j++){
            if(tl[j]!="+"|| tl[j]!="-"||tl[j]!="*"||tl[j]!="/"){
                son+=" "+ tl[j];
            }
        }
        son=son+" "+n;

        return son;
    }

    List<String> tl=new ArrayList<>();
        tl= Arrays.asList(splitToTokens(girdi));
        List<String> tl2=new ArrayList<>();//işaretler
        List<String> tl3=new ArrayList<>();//sayılar
        int n = 0;
        int m = 0;
        for(int i=0;i<girdi.length();i++){
            if(tl.get(i) =="+"|| tl.get(i)=="-"||tl.get(i)=="*"||tl.get(i)=="/"||tl.get(i)=="("||tl.get(i)==")"){
                tl2.set(n, tl.get(i));
                n++;
            }
            else{
                tl3.set(m,tl.get(i));
                m++;
            }
        }

    */
