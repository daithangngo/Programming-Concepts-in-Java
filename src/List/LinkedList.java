package List;

import java.util.Iterator;

public class LinkedList<T> {

    private LinkedListNode<T> head = null;

    /**
     * Insert at the front of the list
     */
    public void add(T value) {
        LinkedListNode<T> node = new LinkedListNode<>(value);
        node.setNext(head);
        head = node;
    }

    /**
     * Remove from the front of the list
     */
    public void removeFirst(){
        if(head.getNext()!=null)
            head = head.getNext();
        else head = null;
    }

    /**
     * Recursively traverse this list and print the node value
     * @param node
     */
    private void printList(LinkedListNode<T> node) {
        System.out.println("Node is " + node.getValue());
        if(node.getNext()!=null) printList(node.getNext());
    }

    public void print(){
        printList(head);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(head.getValue());
        for(var node = head.getNext(); node.hasNext();node = node.getNext()){
            sb.append(", " + node.getValue());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Manish");
        list.add("Pandit");
        list.add("Tanvi");
        list.add("Monika");
        list.print();
        list.removeFirst();
        System.out.println("After removing the head..");
        list.toString();
    }

}

class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public boolean hasNext(){
        return this.getNext() != null;
    }

}