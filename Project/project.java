import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        int processes[] = {1, 2, 3, 4};
        int burst_time[] = {21, 3, 6, 2};
        int n = processes.length;
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("What option would you like to choose?");
            System.out.println("1. FCFS");
            System.out.println("2. Round Robin");
            System.out.println("3. SRTF");
            System.out.println("4. SJF");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    FCFS.findFCFS(processes, n, burst_time);
                    break;
                case "2":
                    int quantum = 2;
                    RoundRobin.findRR(processes, n, burst_time, quantum);
                    break;
                case "3":
                    SRTF.findSRT(processes, n, burst_time);
                    break;
                case "4":
                    SJF.findSJF(burst_time, n, burst_time);
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
