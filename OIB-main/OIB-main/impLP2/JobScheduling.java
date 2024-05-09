import java.util.*;

class Job {
    int id;
    int arrivalTime;
    int burstTime;

    Job(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class JobScheduling {
    private List<Job> jobs;

    public JobScheduling(int n) {
        jobs = new ArrayList<>(n);
    }

    public void addJob(int id, int arrivalTime, int burstTime) {
        jobs.add(new Job(id, arrivalTime, burstTime));
    }

    public void scheduleFCFS() {
        int currentTime = 0;
        System.out.println("Job Schedule using First Come First Serve (FCFS) Algorithm:");
        System.out.println("Job ID\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time");
        for (Job job : jobs) {
            currentTime = Math.max(currentTime, job.arrivalTime);
            int completionTime = currentTime + job.burstTime;
            int turnaroundTime = completionTime - job.arrivalTime;
            System.out.println(job.id + "\t\t" + job.arrivalTime + "\t\t\t" + job.burstTime + "\t\t\t" + completionTime + "\t\t\t" + turnaroundTime);
            currentTime = completionTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of jobs:");
        int n = scanner.nextInt();
        JobScheduling scheduler = new JobScheduling(n);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Job " + (i + 1) + ":");
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            scheduler.addJob(i + 1, arrivalTime, burstTime);
        }
        scheduler.scheduleFCFS();
    }
}

/* INPUT
Enter the number of jobs:
3
Enter details for Job 1:
Arrival Time: 0
Burst Time: 5
Enter details for Job 2:
Arrival Time: 2
Burst Time: 3
Enter details for Job 3:
Arrival Time: 4
Burst Time: 7

*/
