package Project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin {
    public static void findRR(int processes[], int n, int bt[], int quantum) {
        int remaining_bt[] = new int[n], wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0, t = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<String> ganttChart = new ArrayList<>();

        // Initialize remaining burst times
        for (int i = 0; i < n; i++)
            remaining_bt[i] = bt[i];

        // Processing queue
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (remaining_bt[i] > 0) {
                    done = false;
                    ganttChart.add("P" + (i + 1));

                    if (remaining_bt[i] > quantum) {
                        t += quantum;
                        remaining_bt[i] -= quantum;
                    } else {
                        t += remaining_bt[i];
                        wt[i] = t - bt[i];
                        remaining_bt[i] = 0;
                    }
                }
            }
            if (done) break;
        }

        // Calculate Turnaround Time
        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];

        // Display results
        System.out.println("Processes  Burst Time  Waiting Time  Turnaround Time");
        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.println("  " + (i + 1) + "\t\t" + bt[i] + "\t    " + wt[i] + "\t\t  " + tat[i]);
        }

        System.out.println("Average Waiting Time = " + (float) total_wt / n);
        System.out.println("Average Turnaround Time = " + (float) total_tat / n);

        // Print Gantt Chart
        System.out.print("Gantt Chart: | ");
        for (String p : ganttChart) {
            System.out.print(p + " | ");
        }
        System.out.println();
    }
}
