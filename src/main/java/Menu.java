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
    }
}
