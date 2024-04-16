import java.util.LinkedList;

public class BoundedPriorityQueueSet {

    private LinkedList<Task> queue;
    private final int MAX_SIZE;

    public BoundedPriorityQueueSet(int maxSize) {
        MAX_SIZE = maxSize;
        queue = new LinkedList<Task>();
    }

    public BoundedPriorityQueueSet() {
        MAX_SIZE = 10;
        queue = new LinkedList<Task>();
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

        if (queue.contains(task)) {
            throw new DuplicateElementException("Duplicate Found!");
        }

        for (int i = 1; i <= queue.size(); i++) {
            if (task.getDeadline().isBefore(queue.get(i).getDeadline())){
                return i;
            }
        }
        return queue.size() + 1;
    }


}
