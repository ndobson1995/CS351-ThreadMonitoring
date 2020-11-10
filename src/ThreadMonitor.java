import java.util.Scanner;

//TODO: maybe incorporate runnable interface????
//TODO: fix refresh mechanism(Timer or wait()method ?)

class ThreadMonitor {
    private static void getThreadData(ThreadGroup threadGroup) {
        int noThreads = threadGroup.activeCount();
        int noGroups = threadGroup.activeGroupCount();
        Thread[] threadList = new Thread[noThreads];
        ThreadGroup[] groupsList = new ThreadGroup[noGroups];

        threadGroup.enumerate(threadList);
        threadGroup.enumerate(groupsList);

        printThreadInfo(threadGroup,threadList, groupsList);
    }

    private static void printThreadInfo(ThreadGroup threadGroup, Thread[] threads, ThreadGroup[] groups) {
        System.out.println("\n" + "Thread Group: " + threadGroup.getName( ) + " Max Priority: " + threadGroup.getMaxPriority( ));

        for (Thread listThread: threads){
            System.out.println("Thread: " + listThread.getName() + " Priority: " + listThread.getPriority() + " State: " + listThread.getState() + " Thread ID: " + listThread.getId());
        }
        for(ThreadGroup groupThreads : groups){
            getThreadData(groupThreads);
        }
    }

    static void getRootThreadGroup() {
            ThreadGroup currentThread = Thread.currentThread().getThreadGroup().getParent();
            ThreadGroup rootThread = null;

            if (currentThread.getParent() == null){
                rootThread = currentThread;
            } else {
                System.out.println("Not main thread: " + currentThread.getName());
            }
        getThreadData(rootThread);

    }

    //TODO:refactor this, take out lines 45-49 they can be there own method that can all be used in method (getThreadData^)
    static void searchForThread(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What Thread Name would you like to search for?");
        String option = scan.next();
        ThreadGroup main = Thread.currentThread().getThreadGroup().getParent();
        int num_threads = main.activeCount();
        Thread[] threads = new Thread[num_threads];

        main.enumerate(threads);

        for (Thread listThread: threads){
            if (listThread.getName().contains(option)) {
                System.out.println("Thread: " + listThread.getName() + " Priority: " + listThread.getPriority() + " State: " + listThread.getState() + " Thread ID: " + listThread.getId());
            }
        }

    }


    //TODO:Fix this, its weird and doesnt work right
    static void deleteThread() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What Thread Name would you like to terminate");
        String option = scan.next();
        ThreadGroup main = Thread.currentThread().getThreadGroup().getParent();
        int num_threads = main.activeCount();
        Thread[] threads = new Thread[num_threads];
        main.enumerate(threads);

        for (Thread listThread: threads){
            if (listThread.getName().contains(option)) {
                listThread.interrupt();
                System.out.println("Thread: " + listThread.getName() + "Has Terminated");
            }
        }
    }
}