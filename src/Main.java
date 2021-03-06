import java.util.Scanner;

public class Main implements Runnable {


    @Override
    public void run() {
        while(true) {
            ThreadMonitor.getRootThreadGroup();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        Thread thread1 = new Thread(main);
        thread1.start();


        Scanner scan = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Thread Monitoring System");
            System.out.println("------------------------");
            System.out.println("Please enter your choice");
            System.out.println("1: List all Threads");
            System.out.println("2: Search Thread Name");
            System.out.println("3: Terminate Thread");
            System.out.println("4: Exit Application");

            String choiceStr = scan.nextLine();
            if (choiceStr.matches("[0-9][0-9]*")) {
                option = Integer.parseInt(choiceStr);
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
                    default:
                        System.out.println("Enter a relevant number...");
                }
            }
            else{
                System.err.println("Please enter a number\n");
            }
        }
    }


}
