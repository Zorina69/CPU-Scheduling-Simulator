package Project;

public class FCFS {
    public static void findFCFS(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n], ct[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Calculate Completion Time (CT)
        ct[0] = bt[0];
        for (int i = 1; i < n; i++)
            ct[i] = ct[i - 1] + bt[i];

        // Calculate Turnaround Time (TAT) and Waiting Time (WT)
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i];
            wt[i] = tat[i] - bt[i];
            total_wt += wt[i];
            total_tat += tat[i];
        }

        // Display results
        System.out.println("Processes  Burst Time  Waiting Time  Turnaround Time  Completion Time");
        for (int i = 0; i < n; i++) {
            System.out.println("  " + (i + 1) + "\t\t" + bt[i] + "\t    " + wt[i] + "\t\t  " + tat[i] + "\t\t  " + ct[i]);
        }
        System.out.println("Average Waiting Time = " + (float) total_wt / n);
        System.out.println("Average Turnaround Time = " + (float) total_tat / n);

        // Print Gantt Chart
        System.out.print("Gantt Chart: | ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + " | ");
        }
        System.out.println();
    }
}
