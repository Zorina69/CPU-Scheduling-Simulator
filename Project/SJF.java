package Project;

import java.util.Arrays;
import java.util.Comparator;

public class SJF {
    public static void findSJF(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n], ct[] = new int[n];
        int total_wt = 0, total_tat = 0;
        Integer[][] jobs = new Integer[n][2];

        // Store burst time with process index
        for (int i = 0; i < n; i++)
            jobs[i] = new Integer[]{i, bt[i]};

        // Sort by Burst Time (SJF logic)
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        // Calculate Completion Time (CT)
        ct[0] = jobs[0][1];
        for (int i = 1; i < n; i++)
            ct[i] = ct[i - 1] + jobs[i][1];

        // Calculate Turnaround Time (TAT) and Waiting Time (WT)
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i];
            wt[i] = tat[i] - jobs[i][1];
            total_wt += wt[i];
            total_tat += tat[i];
        }

        // Display results
        System.out.println("Processes  Burst Time  Waiting Time  Turnaround Time  Completion Time");
        for (int i = 0; i < n; i++) {
            System.out.println("  P" + (jobs[i][0] + 1) + "\t\t" + jobs[i][1] + "\t    " + wt[i] + "\t\t  " + tat[i] + "\t\t  " + ct[i]);
        }
        System.out.println("Average Waiting Time = " + (float) total_wt / n);
        System.out.println("Average Turnaround Time = " + (float) total_tat / n);

        // Print Gantt Chart
        System.out.print("Gantt Chart: | ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (jobs[i][0] + 1) + " | ");
        }
        System.out.println();
    }
}
