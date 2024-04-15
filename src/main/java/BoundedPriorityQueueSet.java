import java.util.LinkedList;

public class BoundedPriorityQueueSet {

    private LinkedList<String> queue;
    private final int MAX_SIZE;

    public BoundedPriorityQueueSet(int maxSize) {
        MAX_SIZE = maxSize;
        queue = new LinkedList<String>();
    }

    public BoundedPriorityQueueSet() {
        MAX_SIZE = 10;
        queue = new LinkedList<String>();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public boolean isFull(){
        return queue.size()==MAX_SIZE;
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
