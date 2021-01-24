package hafta3;

import hafta3.DoublyLinkedList;

public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {

    @Override
    public void insertAt(int index, T value) {
        Node<T> newNode = new Node<T>(value,getHead(),null);
        if(index==0){
            addFirst(value);
            //setSize(size()+1);
        }
        else if(index==size()){
            addLast(value);
            //setSize(size()+1);
        }
        else {
            Node<T> nodeRef = getHead();
            for (int i = 1; i < index; i++)
                nodeRef = nodeRef.next;

            newNode.next = nodeRef.next;
            nodeRef.next = newNode;
            newNode.previous = nodeRef;
            newNode.next.previous = newNode;
            setSize(size()+1);
        }


    }


    @Override
    public T removeAt(int index) {
        Node<T> tmp = getHead();
        Node<T> tmp2 = null;
        T a = null;
        if (index == 0) {
            a=removeFirst();
            //setSize(size()-1);
        } else if (index == size()) {
            a=removeLast();
            //setSize(size()-1);
        } else {

            for (int i = 1; i < index; i++)
                tmp = tmp.next;

            tmp2=tmp.next;
            tmp.next=tmp.next.next;

            setSize(size()-1);
        }
        return (T) tmp2;
    }
}