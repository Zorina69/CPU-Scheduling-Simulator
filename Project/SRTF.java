package Project;

public class SRTF {
    public static void findSRT(int processes[], int n, int bt[]) {
        int remaining_bt[] = new int[n], wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        int completed = 0, t = 0, min_bt = Integer.MAX_VALUE, shortest = 0, finish_time;
        boolean check = false;

        for (int i = 0; i < n; i++)
            remaining_bt[i] = bt[i];

        while (completed != n) {
            for (int j = 0; j < n; j++) {
                if ((remaining_bt[j] < min_bt) && remaining_bt[j] > 0) {
                    min_bt = remaining_bt[j];
                    shortest = j;
                    check = true;
                }
            }

            if (!check) {
                t++;
                continue;
            }

            remaining_bt[shortest]--;

            min_bt = remaining_bt[shortest];
            if (min_bt == 0)
                min_bt = Integer.MAX_VALUE;

            if (remaining_bt[shortest] == 0) {
                completed++;
                check = false;
                finish_time = t + 1;
                wt[shortest] = finish_time - bt[shortest];
                if (wt[shortest] < 0)
                    wt[shortest] = 0;
            }
            t++;
        }

        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];

        System.out.println("Processes  Burst Time  Waiting Time  Turnaround Time");
        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.println("  " + (i + 1) + "\t\t" + bt[i] + "\t    " + wt[i] + "\t\t  " + tat[i]);
        }

        System.out.println("Average Waiting Time = " + (float) total_wt / n);
        System.out.println("Average Turnaround Time = " + (float) total_tat / n);
    }

    public static void main(String[] args) {
        int processes[] = {1, 2, 3, 4};
        int burst_time[] = {8, 4, 2, 1};
        int n = processes.length;

        findSRT(processes, n, burst_time);
    }
}
