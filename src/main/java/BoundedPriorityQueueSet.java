import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BoundedPriorityQueueSet {

    private LinkedList<Task> queue;
    private final int MAX_SIZE;

    public BoundedPriorityQueueSet(int maxSize) {
        //preventing maxsize form being less than or equal to zero
        if(maxSize <= 0){
            throw new IllegalArgumentException("The max size must be a positive number");
        }
        MAX_SIZE = maxSize;
        queue = new LinkedList<Task>();
    }

    public BoundedPriorityQueueSet() {
        MAX_SIZE = 10;
        queue = new LinkedList<Task>();
    }

    /**
     * checks number of elements in the queue
     * @return number of elements
     */
    public int size(){
        return queue.size();
    }

    /**
     * Returns true or false depending on if queue is empty
     * @return true if empty or false if not empty
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * check to see if element being entered is already in queue
     * @param task Task element to be checked for in the queue
     * @return true if task already in queue or false otherwise.
     */
    public boolean isDuplicate(Task task){
        return queue.contains(task);
    }

    /**
     * Check to see if queue is full
     * @return true if queue is full or false if not full
     */
    public boolean isFull(){
        return queue.size()==MAX_SIZE;
    }

    /**
     * gives position at which task entered should be put into queue
     * @param task Task to be entered into queue
     * @return int which represents where in queue task should be inserted
     * @throws DuplicateElementException If task already in queue
     */
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
        for (int i = 0; i < queue.size(); i++) {
            if (task.compareTo(queue.get(i)) < 0){
                return i;
            } /*else if (task.compareTo(queue.get(i)) > 0) {
                return i+1;             //useless code so was removed
            }*/
        }
        return queue.size();
    }

    /**
     * adds task to queue
     * @param task Task object to be added to queue
     * @throws DuplicateElementException If task already in queue
     */
    public void add(Task task) throws DuplicateElementException {
        if (isFull()){
            throw new IllegalStateException("Queue is full!");
        }

        queue.add(calcPosition(task), task);
    }

    /**
     * also an add but returns true or false
     * @param task Task object to be added
     * @return True if added or False if not added
     * @throws DuplicateElementException Thrown if task already in queue
     */
    public boolean offer(Task task) throws DuplicateElementException {
        if (isFull() || isDuplicate(task)){
            return false;
        }
        queue.add(calcPosition(task), task);
        return true;
    }

    /**
     * gets copy of first element in queue
     * @return Task which was copied or a NoSuchElementException if queue is empty
     */
    public Task element(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue Empty!");
        }
        Task task2 = queue.get(0);
        return task2;
    }

    /**
     * gets copy of first element in queue
     * @return the copied task or null if queue is empty
     */
    public Task peek(){
        if (isEmpty()){
            return null;
        }
        Task task2 = queue.get(0);
        return task2;
    }


    /**
     * removes first task in queue
     * @return Task which was removed or NoSuchElementException exception if queue is empty
     */
    public Task remove(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue Empty!");
        }
        Task task2 = queue.get(0);
        queue.remove(queue.get(0));
        return task2;
    }

    /**
     * Removes first task in queue
     * @return Task which was removed or null if queue is empty
     */
    public Task poll(){
        if (isEmpty()){
            return null;
        }
        Task task2 = queue.get(0);
        queue.remove(queue.get(0));
        return task2;
    }
}
