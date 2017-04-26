package in.ashwanik.codility.nodes;

/**
 * Created by AshwaniK on 7/9/2016.
 */
public class LinkedListNode<T> {

    private T data;

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    private LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void print() {
        LinkedListNode<T> current = this;
        while (current != null) {
            System.out.print(current.getData() + "\t");
            current = current.next;
        }
        System.out.print("\n");
    }

    public int count() {
        LinkedListNode<T> current = this;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public LinkedListNode<T> getDummy() {
        return new LinkedListNode<>(null);
    }

    @Override
    public String toString() {
        return data + "";
    }
}




