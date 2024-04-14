import java.util.LinkedList;

public class BoundedPriorityQueueSet {
    private Node first;
    private Node last;
    private int numElements = 0;
    private final int MAX_SIZE;

    public BoundedPriorityQueueSet(int maxSize) {
        MAX_SIZE = maxSize;
        first = null;
        last = null;
    }

    public BoundedPriorityQueueSet() {
        MAX_SIZE = 10;
        first = null;
        last = null;
    }

    public int size(){
        return numElements;
    }

    public boolean isEmpty(){
        return numElements==0;
    }

    public boolean isFull(){
        return numElements==MAX_SIZE;
    }

    private int calcPosition(Task task) throws DuplicateElementException {
        if (isFull()){
            return -1;
        }

        if (isEmpty()){
            return 0;
        }

        Node current = first;
        current = current.getNext();
        int position = 1;

        while (current != null && !task.equals(current)) {
            current = current.getNext();
            position++;
        }

        if (task.equals(current)){
            throw new DuplicateElementException("Duplicate Found!");
        }

        return position;
    }


    protected class Node {
        private Task data;
        private Node next;

        public Node(Task data) {
            this.data = data;
            next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public void setData(Task data) {
            this.data = data;
        }

        public Task getData() {
            return this.data;
        }
    }
}
