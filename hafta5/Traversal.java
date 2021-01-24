package hafta5;

import BTNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Traversal {
    public static<T> String inOrder(BTNode<T> node) {

        Stack<BTNode> stack = new Stack<BTNode>();
        List<Integer> result = new ArrayList<Integer>();
        stack.push(node);

        while(!stack.isEmpty()){
            BTNode top = stack.peek();
            if(top.left!=null){
                stack.push(top.left);
                top.left=null;
            }else{
                result.add((Integer) top.value);
                stack.pop();
                if(top.right!=null){
                    stack.push(top.right);
                }
            }
        }
        String a= String.valueOf(result.get(0))+" ";
        for(int i=1;i<result.size();i++){
            a+=result.get(i)+" ";
        }
        return a;
    }

    public static<T> String preOrder(BTNode<T> node) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if(node == null)
            return null;

        Stack<BTNode> stack = new Stack<BTNode>();
        stack.push(node);

        while(!stack.empty()){
            BTNode n = stack.pop();
            returnList.add((Integer) n.value);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        String a= String.valueOf(returnList.get(0))+" ";
        for(int i=1;i<returnList.size();i++){
            a+=returnList.get(i)+" ";
        }
        return a;
    }

    public static<T> String postOrder(BTNode<T> node) {
        List<Integer> res = new ArrayList<Integer>();

        if(node==null) {
            return null;
        }

        Stack<BTNode> stack = new Stack<BTNode>();
        stack.push(node);

        while(!stack.isEmpty()) {
            BTNode temp = stack.peek();
            if(temp.left==null && temp.right==null) {
                BTNode pop = stack.pop();
                res.add((Integer) pop.value);
            }
            else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        String a= String.valueOf(res.get(0))+" ";
        for(int i=1;i<res.size();i++){
            a+=res.get(i)+" ";
        }
        return a;
    }
}
