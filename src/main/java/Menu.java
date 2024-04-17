import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private static BoundedPriorityQueueSet taskQueue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        //Used for methods later
        boolean isRisky = rd.nextBoolean();

        System.out.println("Please enter how big you want to make your queue");
        int maxSize = sc.nextInt();
        //Couldn;t get taskQueue if only used in main method
        //BoundedPriorityQueueSet taskQueue = new BoundedPriorityQueueSet(maxSize);
        taskQueue = new BoundedPriorityQueueSet(maxSize);

        System.out.println("Task manager successfully created");

        String[] menu = {
                "1. Add a new Task",
                "2. View the next Task",
                "3. Mark the next Task as done",
                "4. View the number of Tasks remaining.",
                "5. View the space remaining in the queue",
                "6. Exit"
        };
        while(true){
            showMenu(menu,"Please make your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    addTask(isRisky);
                    break;
                case 2:
                    viewTask(isRisky);
                    break;
                case 3:
                    markTaskDone(isRisky);
                    break;
            }
        }
    }
    public static void showMenu(String[] options, String title) {
        System.out.println(title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }
    public static void addTask(Boolean isRisky) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter owner:");
        String owner = sc.next();

        System.out.println("Enter description:");
        String desc = sc.next();

        System.out.println("Enter deadline YYYY-MM-DD:");
        String deadlineString = sc.next();
        //User can't enter LocalDate data so must parse it
        LocalDate deadline = LocalDate.parse(deadlineString);

        Task userTask = new Task(owner,desc,deadline);

        /*if(isRisky){
            taskQueue.add(userTask);
            System.out.println("Task added");
        } else {
            taskQueue.offer(userTask);
            System.out.println("Task added");
            //would need to throw DuplicateElementException in header
        }*/
        try {
            if(isRisky){
                taskQueue.add(userTask);
                System.out.println("Task added");
            } else {
                taskQueue.offer(userTask);
                System.out.println("Task added");
            }
        }catch (DuplicateElementException e){
            System.out.println("Task failed to add: " + e.getMessage());
        }
    }
    public static void viewTask(boolean isRisky){
        try{
            if (isRisky){
                System.out.println(taskQueue.element());
            }else {
                System.out.println(taskQueue.peek());
            }
        }catch (NoSuchElementException e){
            System.out.println("Failed to view task: " + e.getMessage());
        }
    }
    public static void markTaskDone(boolean isRisky){
        try{
            if (isRisky){
                System.out.println(taskQueue.remove());
            }else {
                System.out.println(taskQueue.poll());
            }
        }catch (NoSuchElementException e){
            System.out.println("Failed to remove task: " + e.getMessage());
        }
    }
}