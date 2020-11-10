import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;

        // add validation
        System.out.println("Thread Monitoring System");
        System.out.println("------------------------");
        System.out.println("Please enter your choice");
        System.out.println("1: List all Threads");
        System.out.println("2: Search Thread Name");
        System.out.println("3: Terminate Thread");
        System.out.println("4: Exit Application");
        option = scan.nextInt();
        switch (option) {
            case 1:
                ThreadMonitor.getRootThreadGroup();
                break;
            case 2:
                ThreadMonitor.searchForThread();
                break;
            case 3:
                ThreadMonitor.deleteThread();
                break;
            case 4:
                System.out.println("Exiting..");
                System.exit(0);
                break;
        }
    }


}
