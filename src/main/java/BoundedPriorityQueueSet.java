import java.util.LinkedList;

public class BoundedPriorityQueueSet<Task> {
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
        if (numElements==0){
            return false;
        }
        return true;
    }

    public boolean isFull(){
        if (numElements==MAX_SIZE){
            return true;
        }
        return false;
    }

    private int calcPosition(Task task){

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
