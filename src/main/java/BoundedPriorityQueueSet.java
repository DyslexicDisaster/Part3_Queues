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

    private int calcPosition(Task task) {
        if (first == null){
            return -1;
        }
        Node current = first;
        int position = 0;

        while (current != null && task.getDeadline().compareTo(current.getData().getDeadline()) > 0) {
            current = current.getNext();
            position++;
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
