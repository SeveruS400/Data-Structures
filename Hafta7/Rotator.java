package Hafta7;

//Hafta 7
public class Rotator {

    public static <T> BTNode<T> solaDondur(BTNode<T> k1){
        BTNode<T> y = k1.right;
        BTNode<T> z = y.left;

        y.left = k1;
        k1.right = z;

        return y;
    }
    public static <T> BTNode<T> sagaDondur(BTNode<T> k2){

        BTNode<T> x = k2.left;
        BTNode<T> z = x.right;

        x.right = k2;
        k2.left = z;

        return x;
    }

    public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3){
        k3.left=solaDondur(k3.left);
        return sagaDondur(k3);
    }

    public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k1){
        return null;
    }


}