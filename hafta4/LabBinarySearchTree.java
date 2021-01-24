package hafta4;

public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree() {
    }

    public LabBinarySearchTree(BTNode<T> root) {
        super(root);
    }

    BTNode<T> ekle(BTNode<T> b) {
        BTNode<T> a = new BTNode<>(null, null, null);
        if (b != null) {
            a = new BTNode<>(b.value, null, null);
            if (b.left != null) {
                a.left = ekle(b.left);
            }
            if (b.right != null) {
                a.right = ekle(b.right);
            }
        }
        return a;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        if (getRoot() == null) {
            return new LabBinarySearchTree<T>();
        } else {

            BTNode<T> newNode = ekle(getRoot());

            return new LabBinarySearchTree<T>(newNode);
        }
    }


    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> current = find(getRoot(), value);

        if (current == null)
            return null;
        else if (current.right != null)
            current = current.right;
        else
            return null;

        while( current.left != null ) {
            current = current.left;
        }

        return current;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> current = find(getRoot(), value);

        if (current == null)
            return null;
        else if (current.left != null)
            current = current.left;
        else
            return null;

        while( current.right != null ) {
            current = current.right;
        }

        return current;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        BTNode<T> current = getRoot();
        BTNode<T> currentTemp= current;

        if (node == getRoot()) {
            return null;
        }

        while(current != null) {

            if (node.value.compareTo(current.value) == 0)
                return currentTemp;

            else if (node.value.compareTo(current.value) > 0) {
                currentTemp = current;
                current = current.right;
            }

            else if (node.value.compareTo(current.value) < 0){
                currentTemp = current;
                current = current.left;
            }
        }

        return null;
    }

}
