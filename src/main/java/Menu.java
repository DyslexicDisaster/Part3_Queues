import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        //Used for methods later
        boolean isRisky = rd.nextBoolean();

        System.out.println("Please enter how big you want to make your queue");
        int maxSize = sc.nextInt();
        BoundedPriorityQueueSet taskQueue = new BoundedPriorityQueueSet(maxSize);

        System.out.println("Task manager successfully created");

        String[] menu = {
                "1. Add a new Task",
                "2. View the next Task",
                "3. Mark the next Task as done",
                "4. View the number of Tasks remaining.",
                "5. View the space remaining in the queue",
                "6. Exit"
        };
    }
    public static void showMenu(String[] options, String title) {
        System.out.println(title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }
}
