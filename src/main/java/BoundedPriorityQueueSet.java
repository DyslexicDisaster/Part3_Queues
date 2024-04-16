import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BoundedPriorityQueueSet {

    private LinkedList<Task> queue;
    private final int MAX_SIZE;

    public BoundedPriorityQueueSet(int maxSize) {
        // Todo: Seb Add validation for max size? maybe?
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

    public boolean isDuplicate(Task task){
        return queue.contains(task);
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

        if (isDuplicate(task)) {
            throw new DuplicateElementException("Duplicate Found!");
        }

        for (int i = 1; i <= queue.size(); i++) {
            if (task.compareTo(queue.get(i)) == -1){
                return i;
            } else if (task.compareTo(queue.get(i)) == 1) {
                return i+1;
            }
        }
        return queue.size() + 1;
    }


    public void add(Task task) throws DuplicateElementException {
        if (isFull()){
            throw new IllegalStateException("Queue is full!");
        }

        queue.add(calcPosition(task), task);
    }


    public boolean offer(Task task) throws DuplicateElementException {
        if (isFull() || isDuplicate(task)){
            return false;
        }
        queue.add(calcPosition(task), task);
        return true;
    }


    public Task element(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue Empty!");
        }
        Task task2 = queue.get(0);
        return task2;
    }


    public Task peek(){
        if (isEmpty()){
            return null;
        }
        Task task2 = queue.get(0);
        return task2;
    }


    public Task remove(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue Empty!");
        }
        Task task2 = queue.get(0);
        queue.remove(queue.get(0));
        return task2;
    }


    public Task poll(){
        if (isEmpty()){
            return null;
        }
        Task task2 = queue.get(0);
        queue.remove(queue.get(0));
        return task2;
    }


}
