package odev4;

import org.w3c.dom.Node;

public class Rotator {

    public static <T> BTNode<T> solaDondur(BTNode<T> k1){
        return null;
    }
    public static <T> BTNode<T> sagaDondur(BTNode<T> k2){
        Node x = k2.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = k2;
        k2.left = T2;

        // Update heights
        k2.value = max(value(k2.left), value(k2.right)) + 1;
        x.value = max(value(x.left), value(x.right)) + 1;

        // Return new root
        return (BTNode<T>) x;
    }
    public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3){
        return null;
    }
    public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k1){
        return null;
    }

}
